package tree;

/**
 * @Author: Usher
 * @Date: 2018/12/30/0030
 * @Description:
 */
public class SerializeandDeserializeBST {
    TreeNode root;
    public String serialize(TreeNode root) {
        this.root = root;
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.root;
    }
}
