package lr2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String encryptedString = in.nextLine();
        System.out.print("Введите ключ: ");
        int shift = in.nextInt();

        char[] charArray = encryptedString.toCharArray();
        long[] longArray = new long[charArray.length];
        char[] newCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            longArray[i] = charArray[i] + shift;
            newCharArray[i] = (char) longArray[i];
        }
        encryptedString = new String(newCharArray);
        System.out.println("Текст после преобразования: " + encryptedString);

        System.out.print("Выполнить обратное преобразование? (y/n) ");
        String answer = in.nextLine();
        while (true) {
            answer = in.nextLine();
            if (answer.equals("y")) {
                charArray = encryptedString.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    longArray[i] = charArray[i] - shift;
                    newCharArray[i] = (char) longArray[i];
                }
                encryptedString = new String(newCharArray);
                System.out.print("Текст после обратного преобразования: " + encryptedString);
                break;
            } else if (answer.equals("n")){
                System.out.print("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
    }
}
