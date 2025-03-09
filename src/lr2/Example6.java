package lr2;

public class Example6 {
    interface Shape {
        double calculateArea();
        double calculatePerimeter();
    }

    static class Circle implements Shape {
        private double radius;

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

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }

    static class Square implements Shape {
        private double side;

        public Square(double side) {
            setSide(side);
        }

        @Override
        public double calculateArea() {
            return side * side;
        }

        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }
    }

    static class Triangle implements Shape {
        private double a;
        private double b;
        private double c;

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

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public void setA(double a) {
            this.a = a;
        }

        public void setB(double b) {
            this.b = b;
        }

        public void setC(double c) {
            this.c = c;
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
