package lr7;

import java.io.File;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists() && file.isFile() && file.canRead()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не существует или недоступен для чтения");
        }

        scanner.close();
    }
}