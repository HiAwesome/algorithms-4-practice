package c01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author moqi
 * On 5/21/20 23:15
 */

public class P028BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * -> % java -cp main.jar c01.P028BinarySearch data/tinyW.txt < data/tinyT.txt
     * 50
     * 99
     * 13
     * -> % java -cp main.jar c01.P028BinarySearch data/largeW.txt < data/largeT.txt
     * 499569
     * 984875
     * 295754
     * 207807
     * 140925
     * 161828
     * ...   ->   3675966 个 int 值
     */
    public static void main(String[] args) {
        // Deprecated
        // int[] whiteList = In.readInts(args[0]);
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0) {
                StdOut.println(key);
            }
        }
    }

}
