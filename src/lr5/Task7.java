package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.print("Введите минимальную длину: ");
        int minLength = scanner.nextInt();

        List<String> randomStrings = generateRandomStrings(size);
        List<String> filteredStrings = filterByLength(randomStrings, minLength);

        System.out.println("Исходный список: " + randomStrings);
        System.out.println("Строки длиннее " + minLength + ": " + filteredStrings);
    }

    private static List<String> generateRandomStrings(int size) {
        Random random = new Random();
        return Stream.generate(() -> {
            int length = random.nextInt(20) + 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char c = (char) (random.nextInt(26) + 'a');
                if (random.nextBoolean()) c = Character.toUpperCase(c);
                sb.append(c);
            }
            return sb.toString();
        }).limit(size).collect(Collectors.toList());
    }

    private static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
