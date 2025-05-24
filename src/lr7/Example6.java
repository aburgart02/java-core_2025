package lr7;

import java.io.*;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String outputFileName = "src/lr7/output.txt";

        try (Scanner scanner = new Scanner(System.in);
             PrintWriter printWriter = new PrintWriter(outputFileName, "UTF-8")) {

            System.out.println("Введите данные для записи в файл (пустая строка для завершения):");

            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                printWriter.println(line.toUpperCase());
            }
            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}