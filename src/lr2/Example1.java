package lr2;

import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = id.nextInt();
        System.out.println("Размер массива равен " + size);
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200);
            System.out.println("Элемент массива [" + i + "] = " + array[i]);
        }

        int minValue = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }

        System.out.print("Минимальное значение: " + minValue + ", индекс(ы) элемента(ов): ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minValue) {
                System.out.print(i + " ");
            }
        }
    }
}
