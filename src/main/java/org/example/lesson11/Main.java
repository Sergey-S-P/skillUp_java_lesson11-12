package org.example.lesson11;

import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] arg) {

        String fileName = getTextFromConsole("Please enter file name: ");

        File myFile = createFile(fileName);

        writeToFile(myFile, numbersFibonachi(""));
    }


    private static String getTextFromConsole(String text) {
        System.out.println(text);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please enter text again: ");
            return getTextFromConsole(text);
        }
    }

    private static File createFile(String fileName) {
        try {
            File myFile = new File(fileName + ".txt");
            myFile.createNewFile();
            return myFile;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please enter text again: ");
            createFile(getTextFromConsole("Please enter file name: "));
        }
        return null;
    }

    private static String numbersFibonachi (String sF) {
        int f1 = 0;
        int f2 = 1;
        int f = 0;
        for (int i = 0; i < 20; i++) {
            f = f2 + f1;
            f1 = f2;
            f2 = f;
            sF += Integer.toString(f) + ", ";
        }
        return sF;
    }


    private static void writeToFile (File file, String sF){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

