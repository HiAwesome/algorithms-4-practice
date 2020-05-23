package c01;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

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

        /*
         * 源代码 while 中为 !StdIn.isEmpty()
         * 在控制台读取数据时永远不会返回 false，具体可以参考
         * https://stackoverflow.com/questions/29227821/hasnext-not-work-correctly
         * 所以更新代码为输入 quit 退出
         */
        while (!Objects.equals("quit", StdIn.readAll())) {
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
