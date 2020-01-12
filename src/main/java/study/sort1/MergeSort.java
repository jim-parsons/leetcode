package study.sort1;

import study.util.SortUtil;

public class MergeSort {

    public static void sort(int[] arr) {
        // 此处是闭区间[0, n]
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void sort1(int[] arr) {
        //自低向上
        int n = arr.length;
        // sz 表示归并元素的的个数,从1开始,每次增加1倍,1->2->4...
        for (int sz = 1; sz <= n; sz += sz) {
            // 归并的其实位置,每次取两部分
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对arr[i...i+sz-1] 和 [i+sz...i+sz+sz-1]进行归并
                // 归并至少是两个数组,所以要保证第二个数组存在,那么i+sz < n
                // 同时保证i+sz+sz-1不能越界
                doMergeSort(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    private static void mergeSort(int[] arr, int l, int h) {
        // 递归退出条件
        if (l >= h) return;
        // 每次进行一半一半处理
        int mid = l + ((h - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);
        // 排序
        // 因为[l...mid], [mid+1...h]数组内已经是有序的
        if (arr[mid] > arr[mid + 1])
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
        sort1(intArrs);
        SortUtil.printArrs(intArrs);
    }
}
