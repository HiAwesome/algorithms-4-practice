import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * https://algs4.cs.princeton.edu/13stacks/Stats.java.html
 *
 * @author moqi
 * On 5/23/20 10:13
 */
public class P077Stats {

    /**
     * 100 99 101 120 98 107 109 81 101 90
     * <p>
     * Mead: 100.60
     * Std dev: 10.51
     */
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

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
