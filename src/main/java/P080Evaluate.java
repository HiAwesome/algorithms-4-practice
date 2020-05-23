import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;
import java.util.Stack;

/**
 * @author moqi
 * On 5/23/20 11:26
 */
public class P080Evaluate {

    /**
     * -> % jcmj P080Evaluate
     * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
     * 101.0
     * -> % jcmj P080Evaluate
     * ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
     * 1.618033988749895
     */
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            // 在第二行输入 q 退出
            if (Objects.equals("q", s)) {
                break;
            }

            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+":
                            v = vals.pop() + v;
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = vals.pop() * v;
                            break;
                        case "/":
                            v = vals.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }
                    vals.push(v);
                    break;
                default:
                    vals.push(Double.parseDouble(s));
                    break;
            }

        }

        StdOut.println(vals.pop());
    }

}
