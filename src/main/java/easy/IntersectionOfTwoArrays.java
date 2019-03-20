package easy;

import study.sort.util.SortUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : tom
 * @date : 2019-03-20 15:16
 **/
public class IntersectionOfTwoArrays {
    /**
     * 349
     *
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序
     *
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>(nums1.length);
        for (int i : nums1) {
            s1.add(i);
        }
        Set<Integer> s2 = new HashSet<Integer>(nums1.length);
        int index = 0;
        for (int i : nums2) {
            if (s1.contains(i)) {
                s2.add(i);
            }
        }
        int[] res = new int[s2.size()];
        int i = 0;
        Iterator<Integer> iterator = s2.iterator();
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int[] res = i.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        SortUtil.printArrs(res);
    }
}
