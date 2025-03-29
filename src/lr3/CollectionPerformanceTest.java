package lr3;

import java.util.*;

public class CollectionPerformanceTest {
    private static final int COLLECTION_SIZE = 4_000_000;
    private static final long GET_OPERATIONS = 4_000_000_000L;

    public static void main(String[] args) {
        System.out.println("Добавление в начало:");
        //System.out.println("ArrayList: " + addBeginArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + addBeginTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + addBeginLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nДобавление в конец:");
        System.out.println("ArrayList: " + addEndArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + addEndTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + addEndLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nДобавление в середину:");
        //System.out.println("ArrayList: " + addMiddleArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + addMiddleTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + addMiddleLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nУдаление из начала:");
        //System.out.println("ArrayList: " + removeBeginArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + removeBeginTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + removeBeginLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nУдаление из конца:");
        System.out.println("ArrayList: " + removeEndArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + removeEndTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + removeEndLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nУдаление из середины:");
        //System.out.println("ArrayList: " + removeMiddleArrayList(COLLECTION_SIZE) + " ns");
        System.out.println("TreeSet: " + removeMiddleTreeSet(COLLECTION_SIZE) + " ns");
        System.out.println("LinkedHashMap: " + removeMiddleLinkedHashMap(COLLECTION_SIZE) + " ns");

        System.out.println("\nПолучение по индексу:");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            arrayList.add(i);
        }
        System.out.println("ArrayList: " + getArrayListTime(arrayList, GET_OPERATIONS) + " ns");

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            treeSet.add(i);
        }
        System.out.println("TreeSet: " + getTreeSetTime(treeSet, GET_OPERATIONS) + " ns");

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            linkedHashMap.put(i, i);
        }
        System.out.println("LinkedHashMap: " + getLinkedHashMapTime(linkedHashMap, GET_OPERATIONS) + " ns");
    }

    private static long addBeginArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.add(0, i);
        }
        return System.nanoTime() - start;
    }

    private static long addBeginTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = elements - 1; i >= 0; i--) {
            set.add(i);
        }
        return System.nanoTime() - start;
    }

    private static long addBeginLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.put(0, i);
        }
        return System.nanoTime() - start;
    }

    private static long addEndArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    private static long addEndTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        return System.nanoTime() - start;
    }

    private static long addEndLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.put(i, i);
        }
        return System.nanoTime() - start;
    }

    private static long addMiddleArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.add(list.size() / 2, i);
        }
        return System.nanoTime() - start;
    }

    private static long addMiddleTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        return System.nanoTime() - start;
    }

    private static long addMiddleLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.put(i, i);
        }
        return System.nanoTime() - start;
    }

    private static long removeBeginArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.remove(0);
        }
        return System.nanoTime() - start;
    }

    private static long removeBeginTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            set.pollFirst();
        }
        return System.nanoTime() - start;
    }

    private static long removeBeginLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < elements; i++) {
            map.put(i, i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.remove(i);
        }
        return System.nanoTime() - start;
    }

    private static long removeEndArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.remove(list.size() - 1);
        }
        return System.nanoTime() - start;
    }

    private static long removeEndTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            set.pollLast();
        }
        return System.nanoTime() - start;
    }

    private static long removeEndLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < elements; i++) {
            map.put(i, i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.remove(elements - 1 - i);
        }
        return System.nanoTime() - start;
    }

    private static long removeMiddleArrayList(int elements) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            list.remove(list.size() / 2);
        }
        return System.nanoTime() - start;
    }

    private static long removeMiddleTreeSet(int elements) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        long start = System.nanoTime();
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < elements; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        return System.nanoTime() - start;
    }

    private static long removeMiddleLinkedHashMap(int elements) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < elements; i++) {
            map.put(i, i);
        }
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            map.remove(elements / 2);
        }
        return System.nanoTime() - start;
    }

    private static long getArrayListTime(ArrayList<Integer> list, long operations) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operations; i++) {
            list.get(random.nextInt(list.size()));
        }
        return System.nanoTime() - start;
    }

    private static long getTreeSetTime(TreeSet<Integer> set, long operations) {
        long start = System.nanoTime();
        Random random = new Random();
        List<Integer> elements = new ArrayList<>(set);
        for (int i = 0; i < operations; i++) {
            int index = random.nextInt(elements.size());
            set.ceiling(elements.get(index));
        }
        return System.nanoTime() - start;
    }

    private static long getLinkedHashMapTime(LinkedHashMap<Integer, Integer> map, long operations) {
        long start = System.nanoTime();
        Random random = new Random();
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < operations; i++) {
            int index = random.nextInt(keys.size());
            map.get(keys.get(index));
        }
        return System.nanoTime() - start;
    }
}