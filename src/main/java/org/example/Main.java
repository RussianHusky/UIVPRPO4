package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст с телефонными номерами:");
        String input = scanner.nextLine();

        String formattedText = formatPhoneNumbers(input);

        System.out.println("\nРезультат форматирования:");
        System.out.println(formattedText);
    }

    private static String formatPhoneNumbers(String text) {
        String phonePattern = "(\\+?\\d{1,3})?[\\s\\-\\.]?\\(?(\\d{3})\\)?[\\s\\-\\.]?(\\d{3})[\\s\\-\\.]?(\\d{2})[\\s\\-\\.]?(\\d{2})";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            // Форматируем номер: +1 (XXX) XXX-XX-XX
            String formattedNumber = "+1 (" + matcher.group(2) + ") " +
                    matcher.group(3) + "-" +
                    matcher.group(4) + "-" +
                    matcher.group(5);
            matcher.appendReplacement(result, formattedNumber);
        }
        matcher.appendTail(result);

        return result.toString();
    }
}