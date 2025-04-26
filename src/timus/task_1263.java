package timus;

import java.util.Scanner;

public class task_1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] votes = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int candidate = scanner.nextInt();
            votes[candidate]++;
        }

        for (int i = 1; i <= N; i++) {
            double percentage = (votes[i] * 100.0) / M;
            System.out.printf("%.2f%%\n", percentage);
        }
    }
}
