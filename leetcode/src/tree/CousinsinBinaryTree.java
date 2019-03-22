package tree;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/3/16/0016
 * @Description:
 */
public class CousinsinBinaryTree {
    public boolean isCousins2(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Map.Entry<Integer, Integer> mapX = maxDepth(root, x);
        Map.Entry<Integer, Integer> mapY = maxDepth(root, y);
        System.out.println(mapX);
        System.out.println(mapY);
        return mapX.getKey().equals(mapY.getKey()) && !mapX.getValue().equals(mapY.getValue());
    }

    private Map.Entry<Integer,Integer> maxDepth(TreeNode root, int num) {
        int nodeMaxDepth = 0, parentNode = 0;
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max_depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode cur = queue.poll();

                if (cur.left != null ) {
                    if (cur.left.val == num) {
                        nodeMaxDepth = max_depth;
                        parentNode = cur.val;
                        break;
                    }
                } else if (cur.right != null) {
                    if (cur.right.val == num) {
                        nodeMaxDepth = max_depth;
                        parentNode = cur.val;
                        break;
                    }
                }

                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ++max_depth;
        }
        //return Math.max(maxDepth(root.left),maxDepth(root.right))+1;//递归
        return new AbstractMap.SimpleEntry<>(nodeMaxDepth, parentNode);
    }

    boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXExist = false;
            boolean isYExist = false;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) {
                    isXExist = true;
                }

                if (cur.val == y) {
                    isYExist = true;
                }

                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }

                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            if (isXExist && isYExist) {
                return true;
            }

        }
        return false;
    }
}
