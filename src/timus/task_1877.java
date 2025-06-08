package timus;

import java.util.Scanner;

public class task_1877 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code1 = scanner.nextLine().trim();
        String code2 = scanner.nextLine().trim();

        int k1 = Integer.parseInt(code1);
        int k2 = Integer.parseInt(code2);

        boolean canHack = (k1 % 2 == 0) || (k2 % 2 == 1);
        System.out.println(canHack ? "yes" : "no");
    }
}