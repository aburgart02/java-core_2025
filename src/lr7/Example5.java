package lr7;

import java.io.*;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String outputFileName = "src/lr7/output.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для записи в файл (пустая строка для завершения):");

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8"))) {

            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}