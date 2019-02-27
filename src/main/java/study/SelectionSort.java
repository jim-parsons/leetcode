package study;

import static study.util.SortUtil.*;
/**
 * @author : tang.chunbo@chinaredstar.com
 * @date : 2019-02-15 17:22
 **/
public class SelectionSort {

    static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
        sort(arr);
        printArrs(arr);
    }


}
