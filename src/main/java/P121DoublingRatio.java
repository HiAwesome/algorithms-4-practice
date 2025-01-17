/******************************************************************************
 *  Compilation:  javac P121DoublingRatio.java
 *  Execution:    java P121DoublingRatio
 *  Dependencies: ThreeSum.java Stopwatch.java StdRandom.java StdOut.java
 *
 *
 *  % java P121DoublingRatio
 *      250     0.0   2.7
 *      500     0.0   4.8
 *     1000     0.1   6.9
 *     2000     0.6   7.7
 *     4000     4.5   8.0
 *     8000    35.7   8.0
 *     4000     3.9   6.6
 *  ...
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * The {@code P121DoublingRatio} class provides a client for measuring
 * the running time of a method using a doubling ratio test.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/14analysis">Section 1.4</a>
 * of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class P121DoublingRatio {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private P121DoublingRatio() {
    }

    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     *
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     * with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth, along
     * with ratios of running times between successive array sizes.
     *
     * -> % jcmj P121DoublingRatio
     * 250     0.0   1.3
     * 500     0.0   5.3
     * 1000     0.0   2.0
     * 2000     0.3   7.3
     * 4000     2.4   7.7
     * 8000    19.9   8.2
     *
     * 可以看到 radio 会趋近于8，也就是 2 的 3 次 方。
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time / prev);
            prev = time;
        }
    }
} 
