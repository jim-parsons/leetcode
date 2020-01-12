package easy;

import study.util.SortUtil;

public class MergeSortedArray {
    /**
     * 88
     *
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     */

    // 可以从后往前,因为nums1后面的位置是空的

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArr = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
           mergedArr[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            mergedArr[k++] = nums1[i++];
        }
        while (j < n) {
            mergedArr[k++] = nums2[j++];
        }
        for (int l = 0; l < nums1.length; l++) {
            nums1[l] = mergedArr[l];
        }
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        SortUtil.printArrs(nums1);
    }
}
