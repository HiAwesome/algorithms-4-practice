import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * https://algs4.cs.princeton.edu/13stacks/Reverse.java.html
 *
 * @author moqi
 * On 5/23/20 18:22
 */

public class P079Reverse {

    /**
     * 1 2 3 4 5
     * <p>
     * ^D
     * 1
     * 2
     * 3
     * 4
     * 5
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }
        for (int i : stack) {
            StdOut.println(i);
        }
    }

}
