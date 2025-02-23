package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input number: ");
        int num = in.nextInt();

        System.out.printf("\n%d, %d, %d, %.0f\n", num - 1, num, num + 1, Math.pow(num - 1 + num + num + 1, 2));
        in.close();
    }
}
