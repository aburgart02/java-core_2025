package lr2;

public class Example5 {
    public static class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double calculateArea() {
            return length * width;
        }

        public double calculatePerimeter() {
            return 2 * (length + width);
        }

        public static void main(String[] args) {
            Rectangle rect = new Rectangle(5, 8);
            System.out.println("Длина: " + rect.getLength());
            System.out.println("Ширина: " + rect.getWidth());
            System.out.println("Площадь: " + rect.calculateArea());
            System.out.println("Периметр: " + rect.calculatePerimeter());
            System.out.println();

            rect.setLength(10);
            rect.setWidth(12);
            System.out.println("Длина: " + rect.getLength());
            System.out.println("Ширина: " + rect.getWidth());
            System.out.println("Площадь: " + rect.calculateArea());
            System.out.println("Периметр: " + rect.calculatePerimeter());
        }
    }
}
