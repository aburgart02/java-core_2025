package timus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class task_1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(findMinimalQ(N));
    }

    private static long findMinimalQ(int N) {
        if (N == 0) return 10;
        if (N == 1) return 1;

        List<Integer> digits = new ArrayList<>();
        for (int i = 9; i >= 2; i--) {
            while (N % i == 0) {
                digits.add(i);
                N /= i;
            }
        }

        if (N != 1) return -1;

        Collections.sort(digits);
        long result = 0;
        for (int d : digits) {
            result = result * 10 + d;
        }
        return result;
    }
}