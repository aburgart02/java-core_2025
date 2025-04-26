package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите подстроку: ");
        String substring = scanner.nextLine();

        List<String> randomStrings = generateRandomStrings(size);
        List<String> result = filterBySubstring(randomStrings, substring);

        System.out.println("Исходный список: " + randomStrings);
        System.out.println("Строки с подстрокой '" + substring + "': " + result);
    }

    private static List<String> generateRandomStrings(int size) {
        Random random = new Random();
        return java.util.stream.IntStream.range(0, size)
                .mapToObj(i -> generateRandomString(random))
                .collect(Collectors.toList());
    }

    private static String generateRandomString(Random random) {
        int length = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            if (random.nextBoolean()) c = Character.toUpperCase(c);
            sb.append(c);
        }
        return sb.toString();
    }

    private static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
