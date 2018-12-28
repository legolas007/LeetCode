package array;

/**
 * @Author: Usher
 * @Date: 2018/12/28/0028
 * @Description:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = rows - 1, c = 0; // 从左下角开始
        while (c <= cols - 1 && r >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                c++;
            else
                r--;
        }
        return false;
    }
}
