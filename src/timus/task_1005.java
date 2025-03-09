package timus;

import java.util.Arrays;
import java.util.Scanner;

public class task_1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int total = Arrays.stream(weights).sum();
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for (int stone : weights) {
            for (int s = total; s >= stone; s--) {
                if (dp[s - stone]) {
                    dp[s] = true;
                }
            }
        }
        int max = 0;
        for (int s = total / 2; s >= 0; s--) {
            if (dp[s]) {
                max = s;
                break;
            }
        }
        System.out.println(total - 2 * max);
    }
}
