package medium;

/**
 * @author : tom
 * @date : 2019-03-18 17:51
 **/
public class MinimumSizeSubarraySum {
    /**
     * 209
     *
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     *
     * 示例:
     *
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (i < nums.length) {
            sum += nums[i++];
            while (sum >= s) {
                min = Math.min(min, i-j);
                sum -= nums[j++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
