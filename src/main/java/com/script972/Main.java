package com.script972;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Для запуска введите любой текст и нажмите <Enter>");
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        WordManipulate word = new WordManipulate();
        word.onCreate();

    }

}
