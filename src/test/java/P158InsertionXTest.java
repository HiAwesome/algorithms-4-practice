/**
 * @author moqi
 * On 5/29/20 09:32
 */

import edu.princeton.cs.algs4.InsertionX;

public class P158InsertionXTest {

    /**
     * 要大幅度提高插入排序的速度并不难，只需要在内循环中将较大的元素都向右移动
     * 而不总是交换元素（这样访问数组的次数就能减半）。
     * debug 观察变化
     */
    public static void main(String[] args) {
        String[] array = {"1", "8", "3", "7", "2", "9", "0", "-1", "6"};
        InsertionX.sort(array);
    }

}
