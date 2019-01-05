package search;

/**
 * @Author: Usher
 * @Date: 2019/1/2
 * @Description:
 *
 * I,backtracking
 * 基本数据类型返回结果全局对象，不可值传递，不会更改原有对象，否则返回值还是初始值
 * visited是否访问过，pos排列的个数，每次回溯，visited置为0初始
 *
 * II,类似于求符合题意的全排列,任意交换两个数
 */
public class BeautifulArrangement {

    int res = 0;
    public  int countArrangement(int N) {


        int[] visited = new int[N + 1];
        helper(N, visited, 1);
        return res;
    }
     void helper(int N, int[] visited, int pos) {
        if (pos > N) {
            ++res;
            return;
        }
        for (int i = 1; i <= N; ++i) {
            if (visited[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                visited[i] = 1;
                helper(N, visited, pos + 1);
                visited[i] = 0;
            }
        }
    }

    int countArrangement2(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) nums[i] = i + 1;
        return helper(N, nums);
    }
    int helper(int n, int[] nums) {
        if (n <= 0) return 1;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (n % nums[i] == 0 || nums[i] % n == 0) {
                int tmp = nums[i];
                nums[i] = nums[n - 1];
                nums[n - 1] = tmp;
                //swap(nums[i], nums[n - 1]);

                res += helper(n - 1, nums);

                tmp = nums[i];
                nums[i] = nums[n - 1];
                nums[n - 1] = tmp;
                //swap(nums[i], nums[n - 1]);
            }
        }
        return res;
    }

}
