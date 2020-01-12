package study.sort1;

import study.util.SortUtil;

public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                // 此处j无需 ≥ 0,因为在j=1时候,只需要和j=0比较即可
                // 寻找arr[i] 在[0, i)中所在的位置,且此区间段已经排好序
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                } else {
                    // 此时arr[i] > arr[i-1],则表明之前的已经排好序
                    break;
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 此时有可能可提前结束，所以插入排序比选择排序有可能快
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                SortUtil.swap(arr, j, j - 1);
            }
        }
    }

    public static void sort2(int[] arr) {
        if(arr == null || arr.length <= 1) return;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            int j;
            // 从当前位置往前,如果前面一个数据比当前目前数据大,则将前面数据复制到后面一个位置
            // 通俗来说,因为前面[0, i)位置已经排好序,然后需要找到当前数据所应该在的位置,假设为index
            // 那么(index,i)这个范围的数据每个数据往后挪一个位置即可
            for (j = i; j > 0 && arr[j - 1] > cur; j--) {
                arr[j] = arr[j - 1];
            }
            // 最后的位置即当前位置在此次循环中应该所在的位置
            arr[j] = cur;
        }

    }
    public static void main(String[] args) {
        int[] intArrs = SortUtil.getIntArrs(10);
        SortUtil.printArrs(intArrs);
        sort2(intArrs);
        SortUtil.printArrs(intArrs);
    }
}
