import edu.princeton.cs.algs4.StdOut;

public class P110Stopwatch {

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public P110Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * Unit tests the {@code P110Stopwatch} data type.
     * Takes a command-line argument {@code n} and computes the
     * sum of the square roots of the first {@code n} positive integers,
     * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
     * It prints to standard output the sum and the amount of time to
     * compute the sum. Note that the discrete sum can be approximated by
     * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
     * <p>
     * -> % jcmj P110Stopwatch 1000
     * 2.109746e+04 (0.00 seconds)
     * 2.109746e+04 (0.00 seconds)
     * <p>
     * -> % jcmj P110Stopwatch 2000
     * 5.965063e+04 (0.00 seconds)
     * 5.965063e+04 (0.00 seconds)
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        P110Stopwatch timer1 = new P110Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        P110Stopwatch timer2 = new P110Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}