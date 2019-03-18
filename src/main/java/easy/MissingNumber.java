package easy;

import study.sort.util.SortUtil;

/**
 * @author : tom
 * @date : 2019-03-18 14:06
 **/
public class MissingNumber {
    /**
     * 268
     *
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * 示例 1:
     *
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     */





    public int missingNumber(int[] nums) {
        // 利用数学
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (1+nums.length)*nums.length/2 - sum;
    }

    public int missingNumber1(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i && nums[i] < n) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                SortUtil.printArrs(nums);
            }
            System.out.print(" " + i);
            System.out.println();
        }
        // 此时已经排好序
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                return i+1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] arr = {9,6,4,2,3,5,7,0,1};
        m.missingNumber1(arr);
        SortUtil.printArrs(arr);
    }
}
