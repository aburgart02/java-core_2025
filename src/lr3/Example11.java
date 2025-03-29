package lr3;

public class Example11 {
    public static void main(String[] args) {
        FromHead();
        System.out.println();
        FromTail();
    }

    private static void FromHead() {
        Node head = null;
        for (int i = 9; i >=0; i--) {
            head = new Node(i, head);
        }

        Node ref = head;
        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }

    private static void FromTail() {
        Node head = null;
        Node tail = null;

        for (int i = 0; i <= 9; i++) {
            Node newNode = new Node(i, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node current = head;
        while (current != null) {
            System.out.println(" " + current.value);
            current = current.next;
        }
    }
}
