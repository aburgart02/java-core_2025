package lr6;

public class Task4 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                System.out.println("Thread #" + threadNumber);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All threads have finished execution");
    }
}