package timus;

import java.util.Scanner;

public class task_1502 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = n * (n + 1) * (n + 2) / 2;
        System.out.println(result);
    }
}