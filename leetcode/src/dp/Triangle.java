package dp;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 法一：从上到下， 下一行的结果根据上一行的路径累计和而计算。
triangle[i][j] += min(triangle[i-1[j-1],triangle[i-1][j])，这样需要处理j=0和j=最大值。
法二：从下往上，每一行的结果根据下面一行的路基累计和而计算。
triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])

 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int[] A = new int[triangle.size()+1];

        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }

        return A[0];
    }

}
