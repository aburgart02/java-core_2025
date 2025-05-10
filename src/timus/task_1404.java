package timus;

import java.util.Scanner;

public class task_1404 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypted = scanner.nextLine().trim();
        scanner.close();

        int length = encrypted.length();
        int[] cipherNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            cipherNumbers[i] = encrypted.charAt(i) - 'a';
        }

        int[] originalNumbers = new int[length];
        originalNumbers[0] = (cipherNumbers[0] - 5 + 26) % 26;

        for (int i = 1; i < length; i++) {
            originalNumbers[i] = (cipherNumbers[i] - cipherNumbers[i - 1] + 26) % 26;
        }

        StringBuilder result = new StringBuilder();
        for (int num : originalNumbers) {
            result.append((char) (num + 'a'));
        }

        System.out.println(result.toString());
    }
}