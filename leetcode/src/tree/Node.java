package tree;

import java.util.List;

/**
 * @Author: Usher
 * @Description:
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};