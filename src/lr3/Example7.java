package lr3;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        inputArray(scanner, array, 0);

        System.out.println("Введенный массив:");
        outputArray(array, 0);
    }

    private static void inputArray(Scanner scanner, int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print("Элемент " + index + ": ");
        array[index] = scanner.nextInt();
        inputArray(scanner, array, index + 1);
    }

    private static void outputArray(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print(array[index] + " ");
        outputArray(array, index + 1);
    }
}
