class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                Node temp = q1.remove();
                if (i < size - 1)
                    temp.next = q1.peek();
                if (temp.left != null)
                    q1.add(temp.left);
                if (temp.right != null)
                    q1.add(temp.right);
            }
        }
        return root;
    }
}