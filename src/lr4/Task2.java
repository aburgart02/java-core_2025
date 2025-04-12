package lr4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);
        int column = -1;

        try {
            System.out.print("Введите номер столбца: ");
            String input = scanner.nextLine();
            column = Integer.parseInt(input);

            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][column]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число. Попробуйте снова.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с номером " + column + " не существует.");
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }
}
