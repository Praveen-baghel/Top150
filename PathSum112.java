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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    private boolean helper(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (isLeaf(root) && targetSum - root.val == 0)
            return true;
        if (isLeaf(root) && targetSum - root.val < 0)
            return false;
        return helper(root.left, targetSum - root.val) || helper(root.right, targetSum - root.val);

    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}