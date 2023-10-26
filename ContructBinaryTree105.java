import java.util.*;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, Map<Integer, Integer> map, int ms, int me) {
        if (ps > pe) {
            return null;
        }
        int val = preorder[ps];
        TreeNode node = new TreeNode(val);
        int pos = map.get(val);
        int leftTreeSize = pos - ms;
        node.left = buildTree(preorder, ps + 1, ps + leftTreeSize, map, ms, pos - 1);
        node.right = buildTree(preorder, ps + leftTreeSize + 1, pe, map, pos + 1, me);
        return node;
    }
}