package lr4;

public class Example9 {
    public static int m() {
        try {
            System.out.println("0");
            return 55; // Выход из метода
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
