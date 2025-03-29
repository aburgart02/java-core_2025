package timus;

import java.util.Scanner;

public class task_1131 {
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long N = scanner.nextLong();
            long K = scanner.nextLong();
            System.out.println(minTime(N, K));
        }

        private static long minTime(long N, long K) {
            if (N == 1) return 0;
            long time = 0;
            long S = 1;
            while (S <= K && S < N) {
                long nextS = S * 2;
                if (nextS > N) {
                    return time + 1;
                }
                S = nextS;
                time++;
            }
            if (S >= N) {
                return time;
            }
            long remaining = N - S;
            long steps = (remaining + K - 1) / K;
            time += steps;
            return time;
        }
    }
}
