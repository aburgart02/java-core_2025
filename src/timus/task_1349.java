package timus;

import java.util.Scanner;

public class task_1349 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n == 0) {
            System.out.println(-1);
            return;
        }

        if (n == 1) {
            System.out.println("1 2 3");
            return;
        }

        if (n > 2) {
            System.out.println(-1);
            return;
        }

        int minA = 101;
        int minB = 101;
        int minC = 101;

        for (int a = 1; a <= 100; a++) {
            for (int b = a + 1; b <= 100; b++) {
                int sumSq = a * a + b * b;
                int c = (int) Math.sqrt(sumSq);
                if (c * c == sumSq && c <= 100 && c > b) {
                    if (a < minA ||
                            (a == minA && b < minB) ||
                            (a == minA && b == minB && c < minC)) {
                        minA = a;
                        minB = b;
                        minC = c;
                    }
                }
            }
        }

        if (minA != 101) {
            System.out.println(minA + " " + minB + " " + minC);
        } else {
            System.out.println(-1);
        }
    }
}