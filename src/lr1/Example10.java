package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input year of birth: ");
        int yearOfBirth = in.nextInt();

        System.out.printf("\nAge: %d\n", Year.now().getValue() - yearOfBirth);
        in.close();
    }
}
