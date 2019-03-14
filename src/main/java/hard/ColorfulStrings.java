package hard;

import java.util.HashSet;

public class ColorfulStrings {

    public static String getKth(int n, int k) {
        int[] arr = new int[n];

        return "";
    }

    public static boolean judge(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!set.contains(1)) {
                    set.add(1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
