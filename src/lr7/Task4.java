package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        File file = new File(fileName);

        if (!file.exists() || !file.isFile() || !file.canRead()) {
            System.out.println("Файл не существует или недоступен для чтения");
            scanner.close();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            System.out.println("Строки, содержащие слово \"" + searchWord + "\":");
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Совпадений не найдено");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}