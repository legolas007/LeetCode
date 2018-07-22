package tree;

/**
 * @Author: Usher
 * @Description:
 * 序列化，反序列化二叉树
 *
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    private int index = -1;
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        String key = root.val + "," + serialize(root.left) + ","
                + serialize(root.right);
        return key;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index++;

        String[] strings = data.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = deserialize(data);
            node.right = deserialize(data);
        }
        return node;
    }

/*
    //0ms
    TreeNode root;
    public String serialize(TreeNode root) {
        this.root = root;
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.root;
    }*/
}
