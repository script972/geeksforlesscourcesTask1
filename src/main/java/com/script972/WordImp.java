package com.script972;

import com.script972.entity.Receipt;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WordImp implements Word {

    private XWPFDocument docxModel;
    private XWPFParagraph content;
    private XWPFRun paragraphConfig;

    public WordImp() {
        docxModel = new XWPFDocument();
        initContent();
    }


    public void saveDocx(String fileName) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName + ".docx");
            docxModel.write(outputStream);
            outputStream.close();
            System.out.println("Успешно записан в файл");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initContent() {
        content = docxModel.createParagraph();
        paragraphConfig = content.createRun();
        paragraphConfig.setFontSize(16);
        paragraphConfig.setFontFamily("Times New Roman");
    }

    public void townCreator(String town) {
        initContent();
        content.setAlignment(ParagraphAlignment.LEFT);
        paragraphConfig.setBold(true);
        paragraphConfig.setText("г.Николаев");
        paragraphConfig.addBreak();
    }

    public void titleCreator(String documentTitle) {
        initContent();
        content.setAlignment(ParagraphAlignment.CENTER);
        paragraphConfig.setFontSize(18);
        paragraphConfig.setText(documentTitle);
    }

    public void contentCreator(String name, String passportSer, int number, String take, String home, String landlord, String summ, String dateExpire) {
        initContent();
        paragraphConfig.setText("Я, " + name + ", паспорт серии " + passportSer + " №" + number + ", выдан " + take +
                " зарегистрирован по адресу: " + home + " получил в долг от " + landlord + ", " + summ +
                " в срок до " + dateExpire);
    }

    public void contentCreator(Receipt res) {
        initContent();
        paragraphConfig.setText("Я, " + res.getName() + ", паспорт серии " + res.getPassportSer() + " №" + res.getNumber() + ", выдан " + res.getTake() +
                " зарегистрирован по адресу: " + res.getHome() + " получил в долг от " + res.getLandlord() + ", " + res.getSumm() +
                " в срок до " + res.getDateEpire());
    }

    public void contentFooter(String name) {
        initContent();
        content.setAlignment(ParagraphAlignment.LEFT);
        paragraphConfig.setText(getDate());
        initContent();
        content.setAlignment(ParagraphAlignment.RIGHT);
        paragraphConfig.setText(name);

    }

    private String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(dateNow);
    }

}
