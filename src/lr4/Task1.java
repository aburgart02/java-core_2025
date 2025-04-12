package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите размер массива: ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Введите элемент " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }

            int sum = 0;
            int count = 0;
            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException("Ошибка: положительные элементы отсутствуют.");
            }

            double average = (double) sum / count;
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число. Программа завершена.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Блок finally выполнен.");
        }
    }
}
