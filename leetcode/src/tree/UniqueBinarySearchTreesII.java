package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[][] dp = new List[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                List<TreeNode> cur = new ArrayList<>();
                for (int k = j; k <= i; k++) {
                    if (dp[j][k - 1] == null) {
                        dp[j][k - 1] = new ArrayList<>();
                        dp[j][k - 1].add(null);
                    }
                    if (dp[k + 1][i] == null) {
                        dp[k + 1][i] = new ArrayList<>();
                        dp[k + 1][i].add(null);
                    }
                    List<TreeNode> left = dp[j][k - 1];
                    List<TreeNode> right = dp[k + 1][i];
                    for (TreeNode leftNode : left) {
                        for (TreeNode rightNode : right) {
                            TreeNode root = new TreeNode(k);
                            root.left = leftNode;
                            root.right = rightNode;
                            cur.add(root);
                        }
                    }
                }
                dp[j][i] = cur;
            }
        }
        return dp[1][n];
    }
}
