package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-19 18:56
 **/
public class PascalTriangle {
    /**
     * 118
     *
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows < 1) {return list;}
        for (int i = 0; i < numRows; i++) {
            List<Integer> inner = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    inner.add(1);
                } else {
                    inner.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }
            }
            list.add(inner);
        }
        return list;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(5));
    }
}
