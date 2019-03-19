package medium;

import study.sort.util.SortUtil;

public class RemoveDuplicatesFromSortedArrayII {
    /**
     * 80
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定 nums = [1,1,1,2,2,3],
     *
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int num : nums) {
            if (len < 2 || num != nums[len - 2]) {
                nums[len++] = num;
            }
        }
        return len;
    }

    public int removeDuplicates1(int[] nums) {
        int len = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
                if (count <= 2) {
                    nums[len++] = nums[i];
                }
            } else {
                count = 1;
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        int[] arr = {1,1,1,2,2,2,3};
        r.removeDuplicates(arr);
        SortUtil.printArrs(arr);
    }
}
