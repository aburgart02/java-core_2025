package timus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class task_1110 {
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int Y = scanner.nextInt();

            List<Integer> solutions = new ArrayList<>();
            for (int X = 0; X < M; X++) {
                if (modPow(X, N, M) == Y) {
                    solutions.add(X);
                }
            }

            if (solutions.isEmpty()) {
                System.out.println(-1);
            } else {
                Collections.sort(solutions);
                StringBuilder output = new StringBuilder();
                for (int x : solutions) {
                    output.append(x).append(" ");
                }
                output.setLength(output.length() - 1);
                System.out.println(output);
            }
        }

        private static long modPow(long base, long exponent, long modulus) {
            long result = 1;
            base %= modulus;
            while (exponent > 0) {
                if (exponent % 2 == 1) {
                    result = (result * base) % modulus;
                }
                base = (base * base) % modulus;
                exponent /= 2;
            }
            return result;
        }
    }
}
