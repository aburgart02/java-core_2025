package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        List<Integer> numbers = generateRandomList(size);
        List<Integer> squares = squareNumbers(numbers);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Квадраты чисел: " + squares);
    }

    private static List<Integer> generateRandomList(int size) {
        Random random = new Random();
        return random.ints(size, 0, 201)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}
