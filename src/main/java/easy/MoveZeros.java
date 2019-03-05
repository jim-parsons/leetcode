package easy;

public class MoveZeros {

    /**
     *  283
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */


    public static void moveZeros1(int[] nums) {
        // 将所有非零元素放到[0, k)位置上
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeros(int[] nums) {
        // 指向[0...k)为非零, [k...]为0元素
        // i == k 说明自己和自己交换
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                } else {
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, 3, 12};
//        moveZeroes1(arr);
        moveZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
