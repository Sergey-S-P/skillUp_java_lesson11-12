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
        writeToFile(myFile, numbersFibonachi(0,1));

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

    static String strFib = "0, ";
    private static String numbersFibonachi (int a, int b) {
        int res = a + b;

        if (res < 100) {
            strFib += Integer.toString(res) + ", ";
            numbersFibonachi(b, res);
        }
        return strFib;
    }

    private static void writeToFile (File file, String strFib){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(strFib);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

