package lr6;

public class Task5 {
    public static int findMax(int[] array) throws InterruptedException {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int cores = Runtime.getRuntime().availableProcessors();
        int chunkSize = array.length / cores;
        int[] results = new int[cores];
        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            final int index = i;
            int start = index * chunkSize;
            int end = (index == cores - 1) ? array.length : start + chunkSize;

            threads[index] = new Thread(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                results[index] = max;
            });

            threads[index].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int max = results[0];
        for (int num : results) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        try {
            int max = findMax(array);
            System.out.println("Maximum element: " + max);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}