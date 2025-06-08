package lr8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadExcelFileEnhanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean fileProcessedSuccessfully = false;

        while (!fileProcessedSuccessfully) {
            try {
                System.out.print("Введите путь к Excel файлу (например, example.xlsx): ");
                String filePath = scanner.nextLine();

                System.out.print("Введите имя листа (например, Товары): ");
                String sheetName = scanner.nextLine();

                try (FileInputStream inputStream = new FileInputStream(filePath);
                     XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

                    XSSFSheet sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        throw new IllegalArgumentException("Лист с именем '" + sheetName + "' не найден в файле.");
                    }

                    System.out.println("\n--- Данные из листа '" + sheetName + "' ---");
                    for (Row row : sheet) {
                        for (Cell cell : row) {
                            System.out.print(cell.toString() + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println("--- Конец данных ---\n");

                    fileProcessedSuccessfully = true;

                }

            } catch (FileNotFoundException e) {
                System.err.println("\n[ОШИБКА]: Файл не найден!");
                System.out.println("[РЕКОМЕНДАЦИЯ]: Проверьте, что путь '" + e.getMessage() + "' указан верно и файл существует.");
            } catch (IOException e) {
                System.err.println("\n[ОШИБКА]: Произошла ошибка при чтении файла.");
                System.out.println("[РЕКОМЕНДАЦИЯ]: Убедитесь, что это корректный Excel файл (.xlsx) и он не поврежден.");
            } catch (IllegalArgumentException e) {
                System.err.println("\n[ОШИБКА]: " + e.getMessage());
                System.out.println("[РЕКОМЕНДАЦИЯ]: Проверьте имя листа. Имя чувствительно к регистру.");
            } catch (Exception e) {
                System.err.println("\n[ОШИБКА]: Произошла непредвиденная ошибка.");
                System.out.println("[ДЕТАЛИ]: " + e.getMessage());
                e.printStackTrace();
            }

            if (!fileProcessedSuccessfully) {
                System.out.print("\nХотите попробовать еще раз? (да/нет): ");
                String userChoice = scanner.nextLine();
                if (!"да".equalsIgnoreCase(userChoice)) {
                    break;
                }
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}