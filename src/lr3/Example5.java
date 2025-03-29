package lr3;

public class Example5 {
    public static void main(String[] args) {
        System.out.println("\nЧисло Фибоначчи для 5 = " + fibonacci(5, 0));
    }

    public static int fibonacci(int n, int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "Вызов fibonacci(" + n + ")");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1, level + 1) + fibonacci(n - 2, level + 1);
        }
    }
}