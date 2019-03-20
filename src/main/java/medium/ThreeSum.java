package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-20 20:31
 **/
public class ThreeSum {
    /**
     * 15
     *
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i+1, high = nums.length-1;
                while (low<high) {
                    if (nums[low]+nums[high] == -nums[i]) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // 跳过相同的
                        while (low < high && nums[low+1] == nums[low]) {low++;}
                        while (low < high && nums[high-1] == nums[high]) {high--;}
                        // 向中间靠着
                        low++;
                        high--;
                    } else if (nums[low]+nums[high] > -nums[i]) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}
