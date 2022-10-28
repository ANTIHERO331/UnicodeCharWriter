package com.antihero.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public final class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please Enter Y for Start or Any Other Keys for Exit");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c = (char) bufferedReader.read();
        if (c == 'Y') {
            System.out.println("Start Writing");
            File unicodeCharFile = new File("unicode.txt");
            if (unicodeCharFile.exists()) {
                unicodeCharFile.delete();
                unicodeCharFile.createNewFile();
            } else {
                unicodeCharFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(unicodeCharFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            int i = 0;
            short Char = 0 /* Short.MIN_VALUE */;
            for (int bufferedChar = Short.toUnsignedInt(Char); bufferedChar <= 65535; bufferedChar++) {
                i++;
                float percent = (float)i / 65536;
                if (i % 10 == 0) {
                    outputStreamWriter.write(i + "");
                    outputStreamWriter.write(" ");
                    outputStreamWriter.write((char) bufferedChar);
                    outputStreamWriter.append("\r\n");
                } else {
                    outputStreamWriter.write(i + "");
                    outputStreamWriter.write(" ");
                    outputStreamWriter.write((char) bufferedChar);
                    outputStreamWriter.write("   ");
                }
                System.out.println("Status: " + (percent * 100) + "%");
            }
            fileOutputStream.close();
        } else {
            System.out.println("Program has been Exit");
        }
    }
}
