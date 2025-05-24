package lr7;

import java.io.*;

public class Task6 {
    public static void main(String[] args) {
        // Создаем объект для сериализации
        PersonWithEmail person = new PersonWithEmail("Иван Иванов", 25, "ivan@example.com");

        // Сериализация объекта в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("person.dat"))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован в файл person.dat");
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        // Десериализация объекта из файла
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("person.dat"))) {
            PersonWithEmail restoredPerson = (PersonWithEmail) ois.readObject();
            System.out.println("Объект восстановлен из файла:");
            System.out.println(restoredPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }
    }
}