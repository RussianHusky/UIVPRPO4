package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст с телефонными номерами:");
        String input = scanner.nextLine();

        System.out.println("\nРезультат форматирования:");
        System.out.println(input);
    }
}