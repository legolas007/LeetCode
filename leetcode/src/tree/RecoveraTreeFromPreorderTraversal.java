package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Usher
 * @Date: 2019/4/16/0016
 * @Description:
 */
public class RecoveraTreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        return helper(S, 1);
    }

    TreeNode helper(String S, int depth) {
        if (S.length() == 0) {
            return null;
        }
        String regex = "(?<=\\d)[-]{" + depth + "}(?=\\d)";
        String[] s = S.split(regex);

        for (String ss : s) {
            System.out.println(ss);
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        if (s.length > 1) {
            root.left = helper(s[1], depth+1);
        }
        if (s.length > 2) {
            root.right = helper(s[2], depth+1);
        }
        return root;
    }

    public TreeNode recoverFromPreorder2(String S) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(0); // 哨兵，最后返回root.left
        stack.push(root);
        for (int i = 0; i < S.length(); ) {
            int count = 1; // 默认加1层深度，防止哨兵被弹出
            for (; S.charAt(i) == '-'; i++) {
                count++;
            }
            while (stack.size() > count) {
                stack.pop();
            }
            int n = 0;
            for (; i < S.length() && S.charAt(i) >= '0' && S.charAt(i) <= '9'; i++) {
                n = n * 10 + (S.charAt(i) - '0');
            }
            TreeNode node = new TreeNode(n);
            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            stack.push(node);
        }
        return root.left;
    }
}
