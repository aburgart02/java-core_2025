package lr3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        System.out.print("Двоичное представление: ");
        printBinary(number);
    }

    public static void printBinary(int n) {
        if (n > 1) {
            printBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}