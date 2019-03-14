package study.sort;


/**
 * @author : tom
 * @date : 2019-03-14 14:36
 **/
public class TopK {

    public static void sort(int[] nums, int k) {
        partition(nums, 0, nums.length - 1, k);
    }

    public static void partition(int[] nums, int low, int high, int k) {
        if (low < high) {
            int j = doPartition(nums, low, high);
            if (j == k - 1) {
                return;
            }
            partition(nums, 0, j - 1, k);
            partition(nums, j + 1, high, k);
        }
    }

    private static int doPartition(int[] nums, int low, int high) {
        int key = nums[low];
        int i = low;
        while (low < high) {
            while (nums[high] >= key && low < high) {
                high--;
            }
            while (nums[low] <= key && low < high) {
                low++;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, low, i);
        return low;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 9, 6, 8, 7, 4};
        sort(arr, 2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
