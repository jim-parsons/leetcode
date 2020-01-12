package study.sort1;

import study.util.SortUtil;

public class MergeSort {

    public static void sort(int[] arr) {
        // 此处是闭区间[0, n]
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int h) {
        // 递归退出条件
        if (l >= h) return;
        // 每次进行一半一半处理
        int mid = l + ((h - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);
        // 排序
        doMergeSort(arr, l, mid, h);
    }

    /**
     * 目标数组arr中从[l...mid] [mid+1...h]分成两个数组,
     * 将这两个数组通过临时空间进行排好序
     *
     * @param arr 目标数组
     * @param l   目标数组的左区间
     * @param mid 目标数组的中间
     * @param h   目标数组的右区间
     */
    private static void doMergeSort(int[] arr, int l, int mid, int h) {
        // 开辟临时空间
        int[] temp = new int[h - l + 1];
        // i,j分别为[l..mid],[mid+1...h]这两个数组的索引
        int i = l, j = mid + 1;
        // k 为临时数组temp的索引
        int k = 0;
        while (i <= mid && j <= h) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= h) {
            temp[k++] = arr[j++];
        }
        // 此时临时数组已经是排好序的,然后将其复制到原数组当中
        // 注意与原数组有l的偏差
        for (int m = 0; m < temp.length; m++) {
            arr[m + l] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] intArrs = SortUtil.getIntArrs(10);
        SortUtil.printArrs(intArrs);
        sort(intArrs);
        SortUtil.printArrs(intArrs);
    }
}
