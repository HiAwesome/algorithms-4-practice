package c01;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author moqi
 * On 5/23/20 10:13
 */

public class P077Stats {

    /**
     * Mead: 123456790.00
     * Std dev: 330326883.39
     */
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        /*numbers.add(10.0D);
        numbers.add(100.0D);
        numbers.add(1000.0D);
        numbers.add(10000.0D);
        numbers.add(100000.0D);
        numbers.add(1000000.0D);
        numbers.add(10000000.0D);
        numbers.add(100000000.0D);
        numbers.add(1000000000.0D);*/

        int N = numbers.size();

        double sum = 0.0;

        for (double d : numbers) {
            sum += d;
        }

        double mean = sum / N;

        sum = 0.0;

        for (double d : numbers) {
            sum += (d - mean) * (d - mean);
        }

        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mead: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);

    }

}
