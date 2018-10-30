package array;

/**
 * @Author: Usher
 * @Description:
 */
public class MaxChunkToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int result = 0, n = arr.length, max = 0;
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, arr[i]);
            if (max == i)
                result++;
        }
        return result;
    }
}
