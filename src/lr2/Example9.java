package lr2;

public class Example9 {
    abstract static class Shape {
        public abstract double calculateArea();
        public abstract double calculatePerimeter();
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Square extends Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }

        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }
    }

    static class Triangle extends Shape {
        private final double a;
        private final double b;

        private final double c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double calculateArea() {
            double halfPerimeter = (a + b + c) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(8);
        Shape square = new Square(5);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Периметр круга: " + circle.calculatePerimeter());

        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());

        System.out.println("Площадь преугольника: " + triangle.calculateArea());
        System.out.println("Периметр треугольника: " + triangle.calculatePerimeter());
    }
}
