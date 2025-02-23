package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input day of the week: ");
        String dayOfWeek = in.nextLine();

        System.out.print("Input month: ");
        String month = in.nextLine();

        System.out.print("Input date: ");
        int date = in.nextInt();

        System.out.printf("\nToday's date: %s, %d %s\n", dayOfWeek, date, month);
        in.close();
    }
}
