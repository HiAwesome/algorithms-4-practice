import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/******************************************************************************
 *  Compilation:  javac P118TwoSum.java
 *  Execution:    java P118TwoSum input.txt
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with n^2 running time. Reads n integers
 *  and counts the number of pairs that sum to exactly 0.
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 *  % java P118TwoSum 2Kints.txt
 *  2
 *
 *  % java P118TwoSum 1Kints.txt
 *  1
 *
 *  % java P118TwoSum 2Kints.txt
 *  2
 *
 *  % java P118TwoSum 4Kints.txt
 *  3
 *
 *  % java P118TwoSum 8Kints.txt
 *  19
 *
 *  % java P118TwoSum 16Kints.txt
 *  66
 *
 *  % java P118TwoSum 32Kints.txt
 *  273
 *
 ******************************************************************************/

public class P118TwoSum {

    // print distinct pairs (i, j) such that a[i] + a[j]  = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    }

    // return number of distinct pairs (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * -> % jcmj P118TwoSum data/1Kints.txt
     * elapsed time = 0.002
     * 1
     * -> % jcmj P118TwoSum data/2Kints.txt
     * elapsed time = 0.006
     * 2
     * -> % jcmj P118TwoSum data/4Kints.txt
     * elapsed time = 0.024
     * 3
     * -> % jcmj P118TwoSum data/8Kints.txt
     * elapsed time = 0.049
     * 19
     * -> % jcmj P118TwoSum data/16Kints.txt
     * elapsed time = 0.143
     * 66
     * -> % jcmj P118TwoSum data/32Kints.txt
     * elapsed time = 0.507
     * 273
     * -> % jcmj P118TwoSum data/1Mints.txt
     * 因为平方的时间复杂度效率太低，程序运行了五分钟，没有完成，杀死程序。
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
} 
