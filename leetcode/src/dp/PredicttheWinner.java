package dp;

/**
 * @Author: Usher
 * @Description:
 *
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 *
 */
public class PredicttheWinner {
    private int[] visited;
    public boolean PredictTheWinner(int[] nums) {
        visited = new int[nums.length * nums.length];
        return getScore(nums, 0, nums.length - 1) >= 0;
    }

    //dp
    public int getScore(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int k = l * nums.length + r;
        if (visited[k] > 0) {
            return visited[k];
        }
        visited[k]=Math.max(nums[l] - getScore(nums, l + 1, r),
                nums[r] - getScore(nums, l, r - 1));
        return visited[k];
    }

/*    //
    public int getScore(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        return Math.max(nums[l] - getScore(nums, l + 1, r),
                nums[r] - getScore(nums, l, r - 1));
    }*/
}
