package timus;

import java.util.Scanner;

public class task_1457 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        double average = (double) sum / n;
        System.out.printf("%.6f", average);
    }
}