package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Usher
 * @Date: 2019/07/07,0007
 * @Description:
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();

        if (label <= 0) {
            return res;
        }

        int level = 0;
        while (Math.pow(2, level) - 1 < label) {
            level++;
        }
        level--;
        while (level != 0) {
            res.addFirst(label);
            int pos = label - (int) Math.pow(2, level);
            label = label - (pos + 1) - pos / 2;
            level--;
        }

        res.addFirst(1);
        return res;
    }
}
