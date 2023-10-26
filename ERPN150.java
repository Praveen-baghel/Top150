import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int first, second;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second + first);
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second * first);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}