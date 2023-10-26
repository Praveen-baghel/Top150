import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(postorder, postorder.length - 1, 0, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int pe, int ps, Map<Integer, Integer> map, int ms, int me) {
        if (ps > pe)
            return null;
        int val = postorder[pe];
        TreeNode node = new TreeNode(val);
        int pos = map.get(val);
        int leftTreeSize = pos - ms;
        node.left = buildTree(postorder, ps + leftTreeSize - 1, ps, map, ms, pos - 1);
        node.right = buildTree(postorder, pe - 1, ps + leftTreeSize, map, pos + 1, me);
        return node;
    }
}