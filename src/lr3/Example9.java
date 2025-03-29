package lr3;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Example9 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "apple");
        map.put(1, "banana");
        map.put(2, "cherry");
        map.put(3, "date");
        map.put(4, "elderberry");
        map.put(5, "fig");
        map.put(6, "grape");
        map.put(7, "honeydew");
        map.put(8, "kiwi");
        map.put(9, "lemon");

        System.out.println("Строки с ключом >5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        List<String> zeroKeyStrings = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                zeroKeyStrings.add(entry.getValue());
            }
        }
        System.out.println("Строки с ключом 0: " + String.join(", ", zeroKeyStrings));

        int product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }
        System.out.println("Произведение ключей с длиной строки >5: " + product);
    }
}