package c01;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author moqi
 * On 5/22/20 08:19
 */

public class P042Flips {

    /**
     * -> % java -cp main.jar c01.P042Flips 10
     * 3 heads
     * 7 tails
     * delta: 4
     * -> % java -cp main.jar c01.P042Flips 100
     * 48 heads
     * 52 tails
     * delta: 4
     * -> % java -cp main.jar c01.P042Flips 1000000
     * 498760 heads
     * 501240 tails
     * delta: 2480
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }

        StdOut.println(heads);
        StdOut.println(tails);

        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));

    }

}
