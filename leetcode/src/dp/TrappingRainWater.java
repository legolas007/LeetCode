package dp;

import java.util.Stack;

/**
 * @Author: Usher
 * @Description:
 */
public class TrappingRainWater {

    /**
     * 我们维护一个一维的dp数组，这个DP算法需要遍历两遍数组，第一遍遍历dp[i]中存入i位置左边的最大值，然后开始第二遍遍历数组，
     * 第二次遍历时找右边最大值，然后和左边最大值比较取其中的较小值，然后跟当前值A[i]相比，如果大于当前值，则将差值存入结果
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int result = 0, max = 0, n = height.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(max, dp[i]);
            max = Math.max(max, height[i]);
            if (dp[i] > height[i])
                result += dp[i] - height[i];
        }
        return result;
    }

    /**
     * 遍历高度，如果此时栈为空，或者当前高度小于等于栈顶高度，则把当前高度的坐标压入栈，注意我们不直接把高度压入栈，而是把坐标压入栈，这样方便我们在后来算水平距离。
     * 当我们遇到比栈顶高度大的时候，就说明有可能会有坑存在，可以装雨水。此时我们栈里至少有一个高度，如果只有一个的话，那么不能形成坑，我们直接跳过，
     * 如果多余一个的话，那么此时把栈顶元素取出来当作坑，新的栈顶元素就是左边界，
     * 当前高度是右边界，只要取二者较小的，减去坑的高度，长度就是右边界坐标减去左边界坐标再减1，二者相乘就是盛水量
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }
}
