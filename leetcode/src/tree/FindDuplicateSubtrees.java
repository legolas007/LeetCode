package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Usher
 * @Description:
 * 使用hashmap记录子树序列化次数
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> counts = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        serialize(root, counts, ans);
        return ans;
    }

    private String serialize(TreeNode root, Map<String, Integer> counts,
                             List<TreeNode> ans) {
        if (root == null) {
            return "#";
        }
        //4,24,4,24,3244,1243244
        String key = root.val + "," + serialize(root.left,counts,ans) + ","
                + serialize(root.right,counts,ans);
        if (counts.containsKey(key)) {
            counts.put(key, counts.get(key) + 1);
        }else {
            counts.put(key, 1);
        }
        if (counts.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }
}
