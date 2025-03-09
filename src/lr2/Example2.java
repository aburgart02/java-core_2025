package lr2;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int lines = id.nextInt();
        System.out.print("Введите количество столбцов: ");
        int columns = id.nextInt();
        System.out.println("Размер массива равен " + lines + "x" + columns);
        int[][] array = new int[lines][columns];

        int number = 0;
        for (int i = 0; i < lines; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = number++;
                }
            } else {
                for (int j = columns - 1; j >= 0; j--) {
                    array[i][j] = number++;
                }
            }
        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
