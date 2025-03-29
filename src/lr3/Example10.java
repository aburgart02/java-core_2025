package lr3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Example10 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        JosephusArrayList josephusArrayList = new JosephusArrayList();
        josephusArrayList.josephus(100000);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        JosephusLinkedList josephusLinkedList = new JosephusLinkedList();
        josephusLinkedList.josephus(100000);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static class JosephusArrayList {
        public static int josephus(int N) {
            ArrayList<Integer> people = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                people.add(i);
            }
            int index = 0;
            while (people.size() > 1) {
                index = (index + 1) % people.size();
                people.remove(index);
            }
            return people.get(0);
        }
    }

    public static class JosephusLinkedList {
        public static int josephus(int N) {
            LinkedList<Integer> people = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                people.add(i);
            }
            int index = 0;
            while (people.size() > 1) {
                index = (index + 1) % people.size();
                people.remove(index);
            }
            return people.getFirst();
        }
    }
}
