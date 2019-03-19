package easy;


import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    /**
     * 448
     *
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 示例:
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [5,6]
     */


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1] && nums[i] != i - 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != i + 1) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindAllNumbersDisappearedinanArray f = new FindAllNumbersDisappearedinanArray();
        System.out.println(f.findDisappearedNumbers(nums));
    }
}
