package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-19 18:56
 **/
public class PascalTriangleII {
    /**
     * 118
     *
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex+1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i-1; j >0 ; j--) {
                System.out.println(i + "===" + j);
                list.set(j, list.get(j)+list.get(j-1));
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        PascalTriangleII p = new PascalTriangleII();
        System.out.println(p.getRow(4));
    }
}
