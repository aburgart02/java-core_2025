package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер первого массива: ");
        int size1 = scanner.nextInt();
        System.out.print("Введите размер второго массива: ");
        int size2 = scanner.nextInt();

        int[] array1 = generateRandomArray(size1);
        int[] array2 = generateRandomArray(size2);
        int[] commonElements = findCommonElements(array1, array2);

        System.out.println("Первый массив: " + Arrays.toString(array1));
        System.out.println("Второй массив: " + Arrays.toString(array2));
        System.out.println("Общие элементы: " + Arrays.toString(commonElements));
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201);
        }
        return array;
    }

    private static int[] findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr1)
                .filter(set2::contains)
                .toArray();
    }
}
