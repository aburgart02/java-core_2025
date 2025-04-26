package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        List<String> randomStrings = generateRandomStringList(size);
        List<String> filteredStrings = filterCapitalizedStrings(randomStrings);

        System.out.println("Исходный список: " + randomStrings);
        System.out.println("Строки с большой буквы: " + filteredStrings);
    }

    private static List<String> generateRandomStringList(int size) {
        Random random = new Random();
        return Stream.generate(() -> generateRandomString(random))
                .limit(size)
                .collect(Collectors.toList());
    }

    private static String generateRandomString(Random random) {
        int length = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c;
            if (i == 0) {
                c = (char) (random.nextInt(26) + (random.nextBoolean() ? 'A' : 'a'));
            } else {
                c = (char) (random.nextInt(26) + (random.nextBoolean() ? 'A' : 'a'));
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
