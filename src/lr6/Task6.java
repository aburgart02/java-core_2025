package lr6;

public class Task6 {
    public static int parallelSum(int[] array) throws InterruptedException {
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
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                results[index] = sum;
            });

            threads[index].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalSum = 0;
        for (int partialSum : results) {
            totalSum += partialSum;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            int sum = parallelSum(array);
            System.out.println("Total sum: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}