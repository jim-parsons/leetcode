package study.util;

import java.util.Random;

/**
 * @author : tang.chunbo@foxmail.com
 * @date : 2019-02-15 17:22
 **/
public class SortUtil {

    private static Random random = new Random();

    public static int[] getIntArrs(int n) {
        assert n > 0;

        int[] arr = new int[n];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = random.nextInt(n);
        }
        return arr;
    }

    /**
     * 产生几乎有序的数组
     * @param len 要产生的数组长度
     * @param swapTimes 从数组中选n组进行交换
     * @return 数组
     */
    public static int[] getNearlyOrderedArrs(int len, int swapTimes) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int posX = random.nextInt(len);
            int posY = random.nextInt(len);
            int tmp = arr[posX];
            arr[posX] = arr[posY];
            arr[posY] = tmp;
        }
        return arr;
    }

    public static void printArrs(int[] arr) {
        assert arr != null;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isSorter(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
