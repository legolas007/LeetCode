package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Usher
 * @Description:
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int rowLen = A.length, colLen = A[0].length;
        int[] col = new int[colLen];

        IntStream.range(0,rowLen).forEach(i->{
            if (A[i][0] == 0)
                IntStream.range(0,A[i].length).forEach(c -> A[i][c] = A[i][c] ^1);
            IntStream.range(0,colLen).forEach(j ->{
                if (A[i][j] == 1)
                    col[j]++;
            });
        });

        IntStream.range(0,colLen).forEach(i -> {
            if (col[i] <= rowLen/2)
                IntStream.range(0,A.length).forEach(r -> A[r][i] = A[r][i]^1);
        });

        return Arrays.stream(A).map(a -> Integer.valueOf(Arrays.stream(a).boxed().map(String::valueOf).reduce("", String::concat), 2)).reduce(0, Integer::sum);
    }
}
