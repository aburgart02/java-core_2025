package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] numbers = generateRandomArray(size);
        int[] evenNumbers = filterEvenNumbers(numbers);

        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201);
        }
        return array;
    }

    private static int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}
