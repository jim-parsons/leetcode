package medium;

import study.sort.util.SortUtil;

/**
 * @author : tom
 * @date : 2019-03-18 15:00
 **/
public class ProductOfArrayExceptSelf {
    /**
     * 238
     *
     * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
     * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     * 示例:
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     */

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left *= nums[i];
        }
        // 1. 此时最后一个元素是最终的
        // 2. 此时每个元素(除最后一个)当前位置左边所有元素乘积
        SortUtil.printArrs(output);
        // 3. 接着从右往左,乘积
        for (int i = nums.length - 1; i >= 0 ; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] arr = {2,3,4,5};
        SortUtil.printArrs(p.productExceptSelf(arr));
    }
}
