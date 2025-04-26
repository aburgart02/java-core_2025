package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.print("Введите пороговое значение: ");
        int threshold = scanner.nextInt();

        List<Integer> numbers = generateRandomList(size);
        List<Integer> result = filterGreaterThan(numbers, threshold);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Числа больше " + threshold + ": " + result);
    }

    private static List<Integer> generateRandomList(int size) {
        Random random = new Random();
        return random.ints(size, 0, 201)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(x -> x > threshold)
                .collect(Collectors.toList());
    }
}
