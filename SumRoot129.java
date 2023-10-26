class TreeNode {
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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currSum) {
        if (root.left == null && root.right == null)
            return currSum * 10 + root.val;
        if (root.left != null && root.right == null)
            return sumNumbers(root.left, currSum * 10 + root.val);
        if (root.left == null && root.right != null)
            return sumNumbers(root.right, currSum * 10 + root.val);
        return sumNumbers(root.left, currSum * 10 + root.val) + sumNumbers(root.right, currSum * 10 + root.val);
    }
}