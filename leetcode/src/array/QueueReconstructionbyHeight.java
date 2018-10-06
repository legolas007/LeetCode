package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        //身高降序，k值升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        int n = people.length;
        List<int[]> tmp = new ArrayList<>();
        for (int[] aPeople : people) {
            tmp.add(aPeople[1], aPeople);//按索引插入到指定位置
        }
        /*
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i][0] = tmp.get(i)[0];
            result[i][1] = tmp.get(i)[1];
        }*/

        return tmp.toArray(new int[people.length][]);
    }
}
