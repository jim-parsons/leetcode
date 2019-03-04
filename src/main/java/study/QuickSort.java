package study;

import static study.util.SortUtil.printArrs;

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
        // int[l+1...j] < v; arr[j+1...i) > v;此时i的位置为当前所要比较的元素index
        // j为哨兵的作用
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if(arr[i] < v) {
                // 此时j+1位置的元素为大于v的
                int tmp = arr[j+1];
                arr[j+1] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }
        // 最后交换l和j的
        int tmp = arr[l];
        arr[l] = arr[j];
        arr[j] = tmp;
        return j;
    }

    public static void sort1(int[] arr){
        doQuickSort(arr, 0, arr.length-1);
    }

    public static void doQuickSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int i, j, temp, t;
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
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;

        doQuickSort(arr, low, i-1);
        doQuickSort(arr, i+1, high);


    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
        sort1(arr);
        printArrs(arr);
    }
}
