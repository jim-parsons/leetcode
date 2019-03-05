package easy;

import study.sort.util.SortUtil;

public class SortColors {
    /**
     * 75
     *
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */

    // 计数排序

    public void sortColors1(int[] nums) {
        int[] c = new int[3];
        for (int i = 0; i < nums.length; i++) {
            c[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < c[0]) {
                nums[i] = 0;
            } else if (i < c[1] + c[0]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void sortColors(int[] nums) {
        // nums[0...zero] == 0
        int zero = -1;
        // nums[two...n-1] == 2
        int two = nums.length;
        for (int i = 0; i < two; ) {
            // 如果为2,则把当前元素nums[i] 与 num[two-1] 交换,two往前挪
            if (nums[i] == 2) {
                nums[i] = nums[--two];
                nums[two] = 2;
            } else if (nums[i] == 0) {
                // 如果为0,则把当前元素nums[i] 与 num[zero+1] 交换,zero后移
                // 此时i也要++
                nums[i++] = nums[++zero];
                nums[zero] = 0;
            } else {
                // 为1则继续++
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        SortUtil.printArrs(nums);
    }
}
