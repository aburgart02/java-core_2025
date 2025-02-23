package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input age: ");
        int age = in.nextInt();

        System.out.printf("\nYear of birth: %d\n", Year.now().getValue() - age);
        in.close();
    }
}
