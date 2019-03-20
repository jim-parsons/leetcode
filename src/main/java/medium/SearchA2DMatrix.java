package medium;

/**
 * @author : tom
 * @date : 2019-03-20 10:06
 **/
public class SearchA2DMatrix {

    /**
     * 74
     *
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例 1:
     *
     * 输入:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     * matrix = [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {return false;}
        // 从右上角
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
