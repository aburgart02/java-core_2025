package lr3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void createHead() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите элемент (или Enter для завершения): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            int data = Integer.parseInt(input);
            addFirst(data);
        }
    }

    public void createTail() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите элемент (или Enter для завершения): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            int data = Integer.parseInt(input);
            addLast(data);
        }
    }

    // Вывод списка
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) tail = head;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insert(int index, int data) {
        if (index < 0) throw new IndexOutOfBoundsException("Отрицательный индекс");
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
            current = current.next;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) tail = newNode;
    }

    public void removeFirst() {
        if (head == null) throw new NoSuchElementException("Список пуст");
        head = head.next;
        if (head == null) tail = null;
    }

    public void removeLast() {
        if (head == null) throw new NoSuchElementException("Список пуст");
        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Отрицательный индекс");
        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
            current = current.next;
        }

        if (current.next == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
        current.next = current.next.next;
        if (current.next == null) tail = current;
    }

    public void createHeadRec() {
        createHeadRecHelper();
    }

    private void createHeadRecHelper() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элемент (или Enter для завершения): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) return;

        int data = Integer.parseInt(input);
        createHeadRecHelper();
        addFirst(data);
    }

    public void createTailRec() {
        createTailRecHelper();
    }

    private void createTailRecHelper() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элемент (или Enter для завершения): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) return;

        int data = Integer.parseInt(input);
        addLast(data);
        createTailRecHelper();
    }

    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        if (node.next == null) return Integer.toString(node.data);
        return node.data + " -> " + toStringRecHelper(node.next);
    }
}