package lr4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива через пробел:");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        byte[] array = new byte[elements.length];

        try {
            for (int i = 0; i < elements.length; i++) {
                array[i] = Byte.parseByte(elements[i]);
            }

            int sum = 0;
            for (byte b : array) {
                sum += b;
            }

            if (sum > Byte.MAX_VALUE || sum < Byte.MIN_VALUE) {
                throw new ArithmeticException("Сумма выходит за пределы диапазона byte");
            }

            System.out.println("Сумма элементов: " + sum);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено нечисловое значение или значение за пределами диапазона byte.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
