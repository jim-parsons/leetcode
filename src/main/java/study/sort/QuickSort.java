package study.sort;

import static study.sort.util.SortUtil.printArrs;
import static study.sort.util.SortUtil.swap;

public class QuickSort {

    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }

    /**
     * 获取数组索引值
     * 对数组arr[l...r]进行partition操作
     * 返回p,是的arr[l...p-1]<arr[p]; arr[p+1...r] >arr[p]
     * @param arr 数组
     * @param l 左边的index
     * @param r 右边的index
     * @return 索引值
     */
    public static int partition(int[] arr, int l, int r){
        int v = arr[l];
        // j为哨兵的作用
        int j = l;

        // 设当前访问元素的下标为i,
        // 则 int[l+1...j] < v < int[j+1...i-1] [i...r] => 此部分为未比较部分
        // 此时继续比较 v 和 arr[i]的大小
        for (int i = l+1; i <= r; i++) {
            if(v > arr[i]) {
                // 此时j+1位置的元素为大于v的第一个元素,
                // j位置的元素为小于v的最后一个元素
                swap(arr, arr[j+1], arr[i]);
                j++;
            }
        }
        // 最后交换l和j的
        swap(arr, l, j);
        return j;
    }

    public static void sort1(int[] arr){
        doQuickSort(arr, 0, arr.length-1);
    }

    public static void doQuickSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int i, j, temp;
        i = low;
        j = high;
        // temp 是基准
        temp = arr[low];

        while (i < j) {
            while (temp <= arr[j] && i < j){
                j--;
            }
            while (temp >= arr[i] && i < j){
                i++;
            }
            //经过两个while,此时已经找到了需要交换的元素
            if(i < j) {
                swap(arr, i, j);
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;

        doQuickSort(arr, low, i-1);
        doQuickSort(arr, i+1, high);


    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
        sort(arr);
        printArrs(arr);
    }
}
