package study.bitree;

public class BinarySearch {

    public static int search(int[] arr, int target) {
        // [low...high]区间内查找
        int low = 0, high = arr.length - 1;
        // low==high时,还是有效的
        while (low <= high) {
            int mid = low + (high - low)/2;//(low + high)/2 容易整型溢出
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
