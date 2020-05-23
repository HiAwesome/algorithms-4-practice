/**
 * @author moqi
 * On 5/21/20 22:30
 */

public class P015 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        // 如果 key 存在于 a[] 中，它的索引不会小于 lo 且不会大于 hi
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

}
