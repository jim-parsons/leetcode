package medium;

public class KthLargestElementInAnArray {
    /**
     * 215
     *
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */

    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        // 原本k为第k大的元素,现在赋值之后k的意义变成了第k小的元素
        k = nums.length - k;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (k < j) {
                high = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }



    public int partition(int[] nums, int low, int high) {
        // 最后要使得nums[low+1...j] < v && nums[j+1...i] > v
        int v = nums[low];
        // 哨兵
        int j = low;
        for (int i = low+1; i <= high; i++) {
            if (nums[i] < v) {
                swap(nums, nums[i], nums[j+1]);
                j++;
            }
        }
        swap(nums, low, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        System.out.println(k.findKthLargest(nums, 2));
    }
}
