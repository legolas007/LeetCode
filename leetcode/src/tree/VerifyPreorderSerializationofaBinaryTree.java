package tree;

/**
 * @Author: Usher
 * @Date: 2019/6/9/0009
 * @Description:
 */
public class VerifyPreorderSerializationofaBinaryTree {
    private int index = -1;

    public boolean isValidSerialization(String preorder) {
        TreeNode node = deserialize(preorder);
        String tmp = serialize(node);
        return tmp.equals(preorder);
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return "#";

        return root.val + "," + serialize(root.left) + ","
                + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        index++;

        String[] strings = data.split(",");
        TreeNode node = null;
        if (index < strings.length && !strings[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = deserialize(data);
            node.right = deserialize(data);
        }
        return node;
    }
}
