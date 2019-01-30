package array;

import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: Usher
 * @Date: 2019/1/28/0028
 * @Description:
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {

        List<int[]> list = IntStream.range(0, nums.size())
                .mapToObj(i -> nums.get(i).stream().map(x -> new int[]{x, i}))
                .flatMap(y -> y)
                .sorted(Comparator.comparingInt(p -> p[0])).collect(Collectors.toList());

        int[] counts = new int[nums.size()];
        BitSet set = new BitSet(nums.size());

        int start = -1;
        int[] res = new int[2];

        for (int i = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            set.set(p[1]);
            counts[p[1]]++;

            if (start == -1) {
                start = 0;
            }

            while (start < i && counts[list.get(start)[1]] > 1) {
                counts[list.get(start)[1]]--;
                start++;
            }

            if(set.cardinality() == nums.size()) {
                if( (res[0] == 0 && res[1] == 0) || (list.get(i)[0] - list.get(start)[0]) < res[1] - res[0]) {
                    res[0] = list.get(start)[0];
                    res[1] = list.get(i)[0];
                }
            }
        }
        return res;
    }
}
