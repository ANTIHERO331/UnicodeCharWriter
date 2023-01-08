package com.antihero.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharacterPrinter {
    private final int START_CHARACTER;
    private final int END_CHARACTER;

    public CharacterPrinter () {
        System.out.println("Please Enter Y for Start or Any Other Keys for Exit");
        this.START_CHARACTER = 0;
        this.END_CHARACTER = 65536;
    }

    public CharacterPrinter (int START_CHARACTER, int END_CHARACTER) {
        System.out.println("Please Enter Y for Start or Any Other Keys for Exit");
        this.START_CHARACTER = START_CHARACTER;
        this.END_CHARACTER = END_CHARACTER;
    }

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c = (char) bufferedReader.read();
        if (c == 'Y') {
            System.out.println("Start Writing");
            File unicodeCharFile = new File("unicode.txt");
            if (unicodeCharFile.exists()) {
                try {
                    unicodeCharFile.delete();
                    unicodeCharFile.createNewFile();
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    unicodeCharFile.createNewFile();
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(unicodeCharFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            int i = 0;
            short Char = 0 /* Short.MIN_VALUE */;
            if (START_CHARACTER >= 0 && END_CHARACTER > START_CHARACTER) {
                for (int bufferedChar = START_CHARACTER; bufferedChar <= END_CHARACTER; bufferedChar++) {
                    i++;
                    float percent = (float) i / END_CHARACTER;
                    print(outputStreamWriter, i, (char) bufferedChar, percent);
                }
            } else if (START_CHARACTER == 0 && END_CHARACTER == 0) {
                for (int bufferedChar = Short.toUnsignedInt(Char); bufferedChar <= 65535; bufferedChar++) {
                    i++;
                    float percent = (float) i / 65536;
                    print(outputStreamWriter, i, (char) bufferedChar, percent);
                }
                fileOutputStream.close();
            } else {
                System.out.println("Illegal input characters. You must type integers which are following the rules!");
            }
        } else {
            System.out.println("Program has been Exit");
        }
    }

    private static void print(OutputStreamWriter outputStreamWriter, int i, char bufferedChar, float percent) throws IOException {
        if (i % 10 == 0) {
            outputStreamWriter.write(i + "");
            outputStreamWriter.write(" ");
            outputStreamWriter.write(bufferedChar);
            outputStreamWriter.append("\r\n");
            outputStreamWriter.flush();
        } else {
            outputStreamWriter.write(i + "");
            outputStreamWriter.write(" ");
            outputStreamWriter.write(bufferedChar);
            outputStreamWriter.write("   ");
            outputStreamWriter.flush();
        }
        System.out.println("Status: " + (int) (percent * 100) + "%");
    }
}
