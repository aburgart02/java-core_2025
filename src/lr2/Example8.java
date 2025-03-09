package lr2;

public class Example8 {
    static class Animal {
        private String name;
        private int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
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

        public void makeSound() { }
    }

    static class Dog extends Animal {
        private final String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public void makeSound() {
            System.out.println("Гав!");
        }
    }

    static class Cat extends Animal {
        private final String foodType;

        public Cat(String name, int age, String foodType) {
            super(name, age);
            this.foodType = foodType;
        }

        public String getFoodType() {
            return foodType;
        }

        @Override
        public void makeSound() {
            System.out.println("Мяу!");
        }
    }

    static class Bird extends Animal {
        private final boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }

        public boolean canFly() {
            return canFly;
        }

        @Override
        public void makeSound() {
            System.out.println("Чирик!");
        }

        public void fly() {
            if (canFly) {
                System.out.println(getName() + " может летать");
            } else {
                System.out.println(getName() + " не может летать");
            }
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Рекс", 3, "Овчарка");
        Cat cat = new Cat("Барсик", 2, "Премиум корм");
        Bird bird = new Bird("Ара", 1, true);
        Bird penguin = new Bird("Пингвин", 4, false);

        dog.makeSound();
        System.out.println("Порода: " + dog.getBreed());

        cat.makeSound();
        System.out.println("Тип корма: " + cat.getFoodType());

        bird.makeSound();
        bird.fly();

        penguin.makeSound();
        penguin.fly();
    }
}
