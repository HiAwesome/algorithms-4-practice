import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://algs4.cs.princeton.edu/13stacks/FixedCapacityStackOfStrings.java.html
 *
 * @author moqi
 * On 5/23/20 18:25
 */

public class P082FixedCapacityStackOfStrings implements Iterable<String> {

    private final String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public P082FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    /**
     * -> % jcmj P082FixedCapacityStackOfStrings 5 < data/tobe.txt
     * to be not that or be
     * Left on stack: is to
     */
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        P082FixedCapacityStackOfStrings stack = new P082FixedCapacityStackOfStrings(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public String peek() {
        return a[N - 1];
    }

    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
