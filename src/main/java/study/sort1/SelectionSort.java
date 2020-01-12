package study.sort1;

import study.util.SortUtil;

public class SelectionSort {

    public static void sort(int[] arr) {
        if(arr == null || arr.length == 0) return;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            SortUtil.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] intArrs = SortUtil.getIntArrs(10);
        SortUtil.printArrs(intArrs);
        sort(intArrs);
        SortUtil.printArrs(intArrs);
    }
}
