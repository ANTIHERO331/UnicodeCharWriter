package com.antihero.example;

import java.io.IOException;
import java.util.Scanner;

public final class Main{
    public static void main(String[] args) throws IOException {
        System.out.println("Unicode Character Writer v 1.0. Program made by Antihero. Maker do not prefer any license, so do not distribute!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an integer among 0 to 65536");
        final int START_CHARACTER = scanner.nextInt();
        System.out.println("Please input another integer among which-you-typed-integer to 65536");
        final int END_CHARACTER = scanner.nextInt();
        if (START_CHARACTER == 0 | END_CHARACTER == 0 ) {
            (new CharacterPrinter()).start();
        } else {
            (new CharacterPrinter(START_CHARACTER, END_CHARACTER)).start();
        }
    }
}
