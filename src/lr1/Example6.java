package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input last name: ");
        String last_name = in.nextLine();

        System.out.print("Input first name: ");
        String first_name = in.nextLine();

        System.out.print("Input patronymic: ");
        String patronymic = in.nextLine();

        System.out.print("Hello " + last_name + " " + first_name + " " + patronymic);
        in.close();
    }
}
