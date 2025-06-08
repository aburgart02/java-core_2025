package timus;

import java.util.Scanner;

public class task_1880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        sc.nextLine();
        String[] parts1 = sc.nextLine().split(" ");
        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) {
            a[i] = Integer.parseInt(parts1[i]);
        }

        int n2 = sc.nextInt();
        sc.nextLine();
        String[] parts2 = sc.nextLine().split(" ");
        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) {
            b[i] = Integer.parseInt(parts2[i]);
        }

        int n3 = sc.nextInt();
        sc.nextLine();
        String[] parts3 = sc.nextLine().split(" ");
        int[] c = new int[n3];
        for (int i = 0; i < n3; i++) {
            c[i] = Integer.parseInt(parts3[i]);
        }

        int count = 0;
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {
            int x = a[i], y = b[j], z = c[k];
            if (x == y && y == z) {
                count++;
                i++;
                j++;
                k++;
            } else {
                int min = Math.min(x, Math.min(y, z));
                if (x == min) i++;
                if (y == min) j++;
                if (z == min) k++;
            }
        }

        System.out.println(count);
    }
}