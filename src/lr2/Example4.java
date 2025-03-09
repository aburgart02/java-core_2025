package lr2;

public class Example4 {
    public static class Person {
        private String name;
        private int age;
        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public static void main(String[] args) {
            Person person = new Person("Иван", 25, "Мужской");

            person.setName("Артем");
            person.setAge(23);
            person.setGender("Мужской");
            System.out.println("Имя: " + person.getName());
            System.out.println("Возраст: " + person.getAge());
            System.out.println("Пол: " + person.getGender());
        }
    }
}
