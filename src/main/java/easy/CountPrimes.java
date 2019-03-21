package easy;

import java.util.Arrays;

/**
 * @author : tom
 * @date : 2019-03-21 17:19
 **/
public class CountPrimes {
    /**
     * 204
     *
     * 统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     *
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */
    // cuowu
    public int countPrimes(int n) {
        if (n < 3) {return 0;}
        int[] res = new int[n];
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (res[i] == 1) {
                int m = (int) Math.pow(i, 2);
                while (m < n) {
                    res[m] = 0;
                    m += i;
                }
            }
        }
        return Arrays.stream(res).sum();
    }
}
