import java.util.LinkedList;

class MinStack {
    LinkedList<Node> stack;

    public class Node {
        int min;
        int val;

        public Node(int value, int minimum) {
            this.min = minimum;
            this.val = value;
        }
    }

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        int minimum;
        if (stack.size() == 0) {
            minimum = val;
        } else {
            int currentMin = stack.getFirst().min;
            minimum = val < currentMin ? val : currentMin;
        }
        stack.addFirst(new Node(val, minimum));
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.getFirst().val;
    }

    public int getMin() {
        return stack.getFirst().min;

    }
}