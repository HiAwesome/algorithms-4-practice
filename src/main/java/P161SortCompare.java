/******************************************************************************
 *  Compilation:  javac P161SortCompare.java
 *  Execution:    java P161SortCompare alg1 alg2 n trials
 *  Dependencies: StdOut.java Stopwatch.java
 *
 *  Sort n random real numbers, trials times using the two
 *  algorithms specified on the command line.
 *
 *  % java P161SortCompare Insertion Selection 1000 100
 *  For 1000 random Doubles 
 *    Insertion is 1.7 times faster than Selection
 *
 *  Note: this program is designed to compare two sorting algorithms with
 *  roughly the same order of growth, e,g., insertion sort vs. selection
 *  sort or mergesort vs. quicksort. Otherwise, various system effects
 *  (such as just-in-time compiliation) may have a significant effect.
 *  One alternative is to execute with "java -Xint", which forces the JVM
 *  to use interpreted execution mode only.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class P161SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch sw = new Stopwatch();
        switch (alg) {
            case "Insertion":
                Insertion.sort(a);
                break;
            case "InsertionX":
                InsertionX.sort(a);
                break;
            case "BinaryInsertion":
                BinaryInsertion.sort(a);
                break;
            case "Selection":
                Selection.sort(a);
                break;
            /*case "Bubble":
                Bubble.sort(a); 不存在 Bubble 方法
                break;*/
            case "Shell":
                Shell.sort(a);
                break;
            case "Merge":
                Merge.sort(a);
                break;
            case "MergeX":
                MergeX.sort(a);
                break;
            case "MergeBU":
                MergeBU.sort(a);
                break;
            case "Quick":
                Quick.sort(a);
                break;
            case "Quick3way":
                Quick3way.sort(a);
                break;
            case "QuickX":
                QuickX.sort(a);
                break;
            case "Heap":
                Heap.sort(a);
                break;
            case "System":
                Arrays.sort(a);
                break;
            default:
                throw new IllegalArgumentException("Invalid algorithm: " + alg);
        }
        return sw.elapsedTime();
    }

    // Use alg to sort trials random arrays of length n.
    public static double timeRandomInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = StdRandom.uniform(0.0, 1.0);
            total += time(alg, a);
        }
        return total;
    }

    // Use alg to sort trials random arrays of length n. 
    public static double timeSortedInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        // Perform one experiment (generate and sort an array).
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = 1.0 * i;
            total += time(alg, a);
        }
        return total;
    }

    /**
     * -> % jcmj P161SortCompare Insertion Selection 1000 100
     * For 1000 random Doubles
     * Insertion is 1.0 times faster than Selection
     * -> % jcmj P161SortCompare Insertion Selection 10000 100
     * For 10000 random Doubles
     * Insertion is 0.8 times faster than Selection
     * -> % jcmj P161SortCompare Insertion Selection 1000 1000
     * For 1000 random Doubles
     * Insertion is 1.0 times faster than Selection
     *
     *
     * -> % jcmj P161SortCompare InsertionX Selection 1000 1000
     * For 1000 random Doubles
     *     InsertionX is 1.7 times faster than Selection
     * -> % jcmj P161SortCompare InsertionX Selection 10000 100
     * For 10000 random Doubles
     *     InsertionX is 1.9 times faster than Selection
     *
     *
     * -> % jcmj P161SortCompare Shell Insertion 1000 100
     * For 1000 random Doubles
     *     Shell is 3.8 times faster than Insertion
     * -> % jcmj P161SortCompare Shell Insertion 10000 100
     * For 10000 random Doubles
     *     Shell is 51.9 times faster than Insertion
     *
     *
     *
     */
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int trials = Integer.parseInt(args[3]);
        double time1, time2;
        if (args.length == 5 && args[4].equals("sorted")) {
            time1 = timeSortedInput(alg1, n, trials);   // Total for alg1. 
            time2 = timeSortedInput(alg2, n, trials);   // Total for alg2. 
        } else {
            time1 = timeRandomInput(alg1, n, trials);   // Total for alg1. 
            time2 = timeRandomInput(alg2, n, trials);   // Total for alg2. 
        }

        StdOut.printf("For %d random Doubles\n    %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", time2 / time1, alg2);
    }
} 
