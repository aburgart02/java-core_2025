package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.print("Введите делитель: ");
        int divisor = scanner.nextInt();

        List<Integer> numbers = generateRandomList(size);
        List<Integer> result = filterDivisibleNumbers(numbers, divisor);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Числа, делящиеся на " + divisor + ": " + result);
    }

    private static List<Integer> generateRandomList(int size) {
        Random random = new Random();
        return random.ints(size, 0, 201)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> filterDivisibleNumbers(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}
