package study.sort;

import static study.util.SortUtil.printArrs;

/**
 * @author : tom
 * @date : 2019-02-19 18:52
 **/
public class InsertionSort {

    static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
            }
        }
    }

    /**
     * 对数组arr[low...high]排序
     * @param arr 数组
     * @param low low坐标
     * @param high high坐标
     */
    static void insertSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > low + 1 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    static void sortNearlyOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 将当前位置数据保存
            int temp = arr[i];
            int j;
            // 从后往前比较,如果前面数据大于后面,则直接赋值
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            // 跳出循环,则将初始数据赋值
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,10,7,6,5,9,8};
//        sort(arr);
        sortNearlyOrdered(arr);
        printArrs(arr);
    }
}
