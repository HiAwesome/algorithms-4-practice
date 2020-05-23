import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author moqi
 * On 5/22/20 21:56
 */

public class P057TestAccumulator {

    /**
     * -> %  jcmj P057TestAccumulator 1000
     * n = 1000, mean = 0.5043874325100145, stddev = 0.2862034379756546
     * -> %  jcmj P057TestAccumulator 1000000
     * n = 1000000, mean = 0.5002268186841977, stddev = 0.28876305738024194
     * -> %  jcmj P057TestAccumulator 1000000
     * n = 1000000, mean = 0.49959699826750936, stddev = 0.28875217884815946
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();

        for (int t = 0; t < T; t++) {
            a.addDataValue(StdRandom.uniform());
        }

        StdOut.println(a);
    }

}
