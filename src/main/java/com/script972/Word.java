package com.script972;

import com.script972.entity.Receipt;

import java.io.IOException;

public interface Word {

    void townCreator(String town);

    void titleCreator(String documentTitle);

    void contentCreator(String name, String passportSer, int number, String take, String home, String landlord, String summ, String dateExpire);

    void saveDocx(String fileName);

    void contentCreator(Receipt resiept);

    void contentFooter(String name);
}
