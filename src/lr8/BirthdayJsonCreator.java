package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class BirthdayJsonCreator {
    public static void main(String[] args) {
        JSONObject birthdayList = new JSONObject();
        JSONArray people = new JSONArray();

        JSONObject person1 = new JSONObject();
        person1.put("name", "Иван Иванов");
        person1.put("birthdate", "15.05.1990");

        JSONObject person2 = new JSONObject();
        person2.put("name", "Петр Петров");
        person2.put("birthdate", "23.11.1985");

        JSONObject person3 = new JSONObject();
        person3.put("name", "Анна Сидорова");
        person3.put("birthdate", "01.07.2001");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        birthdayList.put("birthdays", people);

        try (FileWriter file = new FileWriter("src/lr8/birthdays.json")) {
            file.write(birthdayList.toJSONString());
            System.out.println("JSON-файл 'birthdays.json' успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}