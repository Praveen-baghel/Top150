import java.util.Stack;

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
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        TreeNode tempRight = root.right;

        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            leftTail.right = tempRight;
        }

        return rightTail != null ? rightTail : (leftTail != null ? leftTail : root);
    }
}