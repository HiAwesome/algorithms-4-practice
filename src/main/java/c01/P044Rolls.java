package c01;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author moqi
 * On 5/22/20 09:28
 */

public class P044Rolls {

    /**
     * -> % jcmj c01.P044Rolls 1000000
     * 166859 1's
     * 167082 2's
     * 166890 3's
     * 166867 4's
     * 166297 5's
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int SIDES = 6;

        Counter[] rolls = new Counter[SIDES + 1];

        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "'s");
        }

        for (int t = 0; t < T; t++) {
            int result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();
        }

        for (int i = 1; i < SIDES; i++) {
            StdOut.println(rolls[i]);
        }

    }

}
