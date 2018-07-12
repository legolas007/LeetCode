package dp;

/**
 * @Author: Usher
 * @Description:
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                result[i] += result[i - j] * result[j - 1];
            }
        }
        return result[n];
    }
}
