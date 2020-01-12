package easy;

import study.util.SortUtil;

public class TwoSumII {
    /**
     * 167
     *
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
     */

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        if (numbers == null || numbers.length < 2) {
            return arr;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                arr[0] = left+1;
                arr[1] = right+1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return arr;
    }

    public int search(int[] nums, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = (low + high)/2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoSumII t = new TwoSumII();
        int[] arr = {2, 7, 11, 15};
        SortUtil.printArrs(t.twoSum(arr, 9));
    }
}
