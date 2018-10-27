package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 * 对于遍历过的数字，我们不用再将其当作开头来计算了，而是只对于未遍历过的数字当作嵌套数组的开头数字，不过在进行嵌套运算的时候，并不考虑中间的数字是否已经访问过，而是只要找到和起始位置相同的数字位置，然后更新结果res
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length, res = Integer.MIN_VALUE;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[nums[i]])
                continue;
            //res = Math.max(res, helper(nums, i, visited));
            res = Integer.max(res, helper(nums, i, visited));
        }
        return res;
    }

    public int helper(int[] nums, int start, boolean[] visited) {
        int i = start, cnt = 0;
        while (cnt == 0 || i != start) {
            visited[i] = true;
            i = nums[i];
            ++cnt;
        }
        return cnt;
    }
}
