package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input name: ");
        String name = in.nextLine();

        System.out.print("Input year of birth: ");
        int yearOfBirth = in.nextInt();

        System.out.printf("\nName: %s\nAge: %d\n", name, Year.now().getValue() - yearOfBirth);
        in.close();
    }
}
