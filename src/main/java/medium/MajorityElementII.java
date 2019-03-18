package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-18 15:42
 **/
public class MajorityElementII {
    /**
     * 229
     *
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     *
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: [3]
     * 示例 2:
     *
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     */

    // FIXME leecode 没通过
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>(2);
        if (n == 1) {
            list.add(nums[0]);
            return list;
        }
        int num1, num2, count1, count2;
        num1 = nums[0];
        num2 = nums[0];
        count1 = count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else {
                count1--;
                count2--;
                if (count1 == 0) {
                    num1 = nums[i];
                } else if (count2 == 0) {
                    num2 = nums[i];
                }
            }
        }
        count1 = count2 = 0;
        for (Integer num : nums) {
            if (num1 == num) {
                count1++;
            }
            if (num2 == num) {
                count2++;
            }
        }
        if (count1 >= n/3) {
            list.add(num1);
        }
        if (count2 >= n/3) {
            list.add(num2);
        }
        return list;
    }

    public static void main(String[] args) {
        MajorityElementII m = new MajorityElementII();
        int[] arr = {3,2,3};
        System.out.println(m.majorityElement(arr));
    }
}
