package easy;

/**
 * @author : tom
 * @date : 2019-03-20 21:07
 **/
public class ShortestUnsortedContinuousSubarray {

    /**
     * 581
     *
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     *
     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 示例 1:
     *
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     */

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[n-1];
        int start = -1, end = -2;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-i-1]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n-i-1] > min) {
                start = n - i - 1;
            }
            System.out.println(end+"="+start);
        }
        return end-start+1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println("+========");
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));
    }
}
