package lr5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        List<String> randomStrings = generateRandomStrings(size);
        List<String> filteredStrings = filterLettersOnly(randomStrings);

        System.out.println("Исходный список: " + randomStrings);
        System.out.println("Строки только с буквами: " + filteredStrings);
    }

    private static List<String> generateRandomStrings(int size) {
        Random random = new Random();
        return Stream.generate(() -> generateRandomString(random))
                .limit(size)
                .collect(Collectors.toList());
    }

    private static String generateRandomString(Random random) {
        int length = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int type = random.nextInt(3);
            char c;
            switch (type) {
                case 0:
                    c = (char) (random.nextInt(26) + (random.nextBoolean() ? 'A' : 'a'));
                    break;
                case 1:
                    c = (char) (random.nextInt(10) + '0');
                    break;
                default:
                    c = (char) (random.nextInt(15) + 33);
                    break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static List<String> filterLettersOnly(List<String> list) {
        return list.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }
}
