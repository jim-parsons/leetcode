package study.sort1;

import study.util.SortUtil;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        quickSort(arr, 0, arr.length - 1);
    }

    public static void sort1(int[] arr) {
        quickSort1(arr, 0, arr.length - 1);
    }

    private static void quickSort1(int[] arr, int low, int high) {
        if (low >= high) return;
        int p = partition(arr, low, high);
        quickSort1(arr, low, p - 1);
        quickSort1(arr, p + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        // [l...j] < v < [j+1...i-1]  [i...high]
        int v = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < v) {
                // 交换当前元素到j+1的位置,然后j++,此时会依然保持上面的顺序
                SortUtil.swap(arr, j + 1, i);
                j++;
            }
        }
        SortUtil.swap(arr, j, low);
        return j;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        int target = arr[low];
        while (i < j) {
            while (target <= arr[j] && i < j) {
                j--;
            }
            while (target >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                SortUtil.swap(arr, i, j);
            }
        }
        // 此时i=j
        arr[low] = arr[i];
        arr[i] = target;
        SortUtil.printArrs(arr);
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public static void main(String[] args) {
        int[] intArrs = SortUtil.getIntArrs(10);
        SortUtil.printArrs(intArrs);
        System.out.println("===");
        sort1(intArrs);
        System.out.println("===");
        SortUtil.printArrs(intArrs);
    }
}
