package study.sort1;

public class HeapSort {

    private static void heapSort(int[] arr) {
        // 构造初始堆
        for(int i = arr.length / 2 - 1; i>=0; i--){
            adjust(arr, arr.length, i);
        }

        // 排序，将最大的放在堆尾，然后从根节点重新开始调整
        for(int i = arr.length - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, i, 0);
        }
    }


    private static void adjust(int[] arr, int len, int i) {
        int k = i, temp = arr[i], index = 2 * k + 1;

        while (index < len) {
            if(index + 1 < len && arr[index] < arr[index+1]) {
                index++;//
            }
            if(arr[index] > temp) {
                arr[k] = arr[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        arr[k] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8};
        heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
