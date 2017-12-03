package com.script972;

import com.script972.entity.Receipt;
import com.script972.xml.XmlReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordManipulate {

    private Word word;

    public WordManipulate() {
        this.word = new WordImp();
    }

    public void onCreate() {
        List<Receipt> receipts = readFile();
        for (Receipt resiept :
                receipts) {
            word = new WordImp();
            word.townCreator(resiept.getTown());
            word.titleCreator("Расписка");
            word.contentCreator(resiept);
            word.contentFooter(resiept.getName());
            word.saveDocx("Расписка_" + resiept.getName());

        }

    }

    private List<Receipt> readFile() {
        List<Receipt> receiptList = new ArrayList<Receipt>();
        XmlReader xml = new XmlReader();
        try {
            receiptList = xml.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return receiptList;
    }
}
