package graph;

/**
 * @Author: Usher
 * @Description:
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        int m = image.length;
        int n = image[0].length;

        dfs(image, sr, sc, n, m, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int n, int m, int oldColor, int newColor) {
        //终止条件，越界
        if (sr < 0 || sr >= m || sc < 0 || sc >= n) {
            return;
        }
        //已经遍历过，或者是相邻的颜色不相同
        if (image[sr][sc] != oldColor)
            return;
        //填充
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, n, m, oldColor, newColor);
        dfs(image, sr - 1, sc, n, m, oldColor, newColor);
        dfs(image, sr, sc + 1, n, m, oldColor, newColor);
        dfs(image, sr, sc - 1, n, m, oldColor, newColor);
    }
}
