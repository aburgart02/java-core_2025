package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class BirthdayJsonParser {
    private static final String FILE_PATH = "src/lr8/birthdays.json";

    public static void main(String[] args) {
        try {
            System.out.println("--- 1. Чтение исходного файла ---");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(FILE_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray birthdays = (JSONArray) jsonObject.get("birthdays");

            System.out.println("Содержимое файла:");
            printAllBirthdays(birthdays);

            System.out.println("\n--- 2. Поиск человека по имени 'Анна Сидорова' ---");

            birthdays.stream()
                    .filter(p -> p instanceof JSONObject)
                    .map(p -> (JSONObject) p)
                    .forEach(p -> {
                        JSONObject person = (JSONObject) p;
                        if (person.get("name").equals("Анна Сидорова")) {
                            System.out.println("Найден человек:");
                            System.out.println("Имя: " + person.get("name"));
                            System.out.println("Дата рождения: " + person.get("birthdate"));
                        }
                    });

            System.out.println("\n--- 3. Добавление новой записи ---");
            JSONObject newPerson = new JSONObject();
            newPerson.put("name", "Елена Новикова");
            newPerson.put("birthdate", "10.10.1995");
            birthdays.add(newPerson);

            System.out.println("Список после добавления:");
            printAllBirthdays(birthdays);

            System.out.println("\n--- 4. Удаление записи по имени 'Иван Иванов' ---");
            String nameToDelete = "Иван Иванов";
            Iterator iterator = birthdays.iterator();
            while (iterator.hasNext()) {
                JSONObject person = (JSONObject) iterator.next();
                if (nameToDelete.equals(person.get("name"))) {
                    iterator.remove();
                    System.out.println("Запись для '" + nameToDelete + "' удалена.");
                }
            }

            System.out.println("Список после удаления:");
            printAllBirthdays(birthdays);


            try (FileWriter file = new FileWriter(FILE_PATH)) {
                file.write(jsonObject.toJSONString());
                System.out.println("\nИзменения успешно сохранены в файл " + FILE_PATH);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void printAllBirthdays(JSONArray birthdays) {
        for (Object o : birthdays) {
            JSONObject person = (JSONObject) o;
            System.out.println("\tИмя: " + person.get("name") + ", Дата рождения: " + person.get("birthdate"));
        }
    }
}