package lr3;

public class Example12 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Создание списка через createHead:");
        list.createHead();
        System.out.println("Список: " + list);

        System.out.println("\nДобавление 10 в конец:");
        list.addLast(10);
        System.out.println("Список: " + list);

        SinglyLinkedList recList = new SinglyLinkedList();
        System.out.println("\nСоздание списка через createTailRec:");
        recList.createTailRec();
        System.out.println("Рекурсивный вывод: " + recList.toStringRec());
    }
}
