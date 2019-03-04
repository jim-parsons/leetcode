package study.sort;


import static study.sort.util.SortUtil.printArrs;

/**
 * @author : tang.chunbo@foxmail.com
 * @date : 2019-02-19 20:16
 **/
public class MergeSort {

    static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int l, int h) {
        // 优化: 如果gap小于某个值,可以选择使用插入排序
        if (l < h) {
            int mid = (l+h)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr,mid + 1, h);
            if (arr[mid] > arr[mid + 1]) {
                doMerge(arr, l, mid, h);
            }
        }
    }

    /**
     * 将数组两端[l, mid], [mid + 1, r]进行归并
     * @param arr 待排序数组
     * @param l 数组左端
     * @param mid 数组中间
     * @param h 数组右端
     */
    private static void doMerge(int[] arr, int l, int mid, int h) {
       int[] temp = new int[h-l+1];

       int i = l, j = mid + 1;
       int k = 0;
       while (i <= mid && j <= h){
           temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
       }
       while (i <= mid) {
           temp[k++] = arr[i++];
       }
       while (j <= h) {
           temp[k++] = arr[j++];
       }
       for (int x = 0; x < temp.length; x++) {
           arr[x + l] = temp[x];
       }
    }

    public static void mergeSortBU(int[] arr){
        for (int sz = 1; sz <= arr.length; sz=sz*2) {
            for (int i = 0; i + sz < arr.length; i += sz*2) {
                // 对arr[i...i+sz-1]和arr[i+sz...i+2*sz-1]进行归并
                // 每个区间大小为sz-1
                // i + sz + sz -1 可能越界,所以选取他和n-1的小者
                doMerge(arr, i, i +sz -1, Math.min(i + sz + sz -1, arr.length-1));
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
        sort(arr);
        printArrs(arr);
        System.out.println("=======");
        int[] arr1 = {3,2,1,4,10,7,6,5,9,8};
        mergeSortBU(arr1);
        printArrs(arr1);
    }
}
