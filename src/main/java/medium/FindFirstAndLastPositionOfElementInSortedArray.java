package medium;

/**
 * @author : tom
 * @date : 2019-03-20 17:17
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 34
     *
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int start = find(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[] {start, find(nums, target+1) - 1};
    }

    private int find(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] >= target) {
                // 找第一次出现，相等或大于target都要令high = mid
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
