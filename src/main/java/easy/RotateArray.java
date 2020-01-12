package easy;

import study.util.SortUtil;

/**
 * @author : tom
 * @date : 2019-03-18 18:57
 **/
public class RotateArray {
    /**
     * 189
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 先把[0...n-k-1][n-k...n-1]每个进行翻转
        // 最后再把整个数组翻转
        k %= n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);

    }

    private void reverse(int[] nums, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        r.rotate(arr, 3);
        SortUtil.printArrs(arr);
    }
}
