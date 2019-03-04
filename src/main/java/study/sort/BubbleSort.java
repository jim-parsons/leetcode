package study.sort;

import static study.sort.util.SortUtil.printArrs;

/**
 * @author : tang.chunbo@foxmail.com
 * @date : 2019-03-04 14:44
 **/
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
        boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {

                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
        sort(arr);
        printArrs(arr);
    }
}
