package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input month: ");
        String month = in.nextLine();

        System.out.print("Input number of days: ");
        int numberOfDays = in.nextInt();

        System.out.printf("\n%s contains %d days\n", month, numberOfDays);
        in.close();
    }
}
