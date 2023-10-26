import java.util.Stack;

public class BasicCalculator224 {
    public static int calculate(String s) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        s = s.replaceAll("\\s+", "");

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '+':
                    operatorStack.push(ch);
                    break;
                case '-':
                    operatorStack.push(ch);
                    break;
                case '(':
                    operatorStack.push(ch);
                    break;
                case ')':
                    while (operatorStack.peek() != '(') {
                        if (operatorStack.pop() == '+') {
                            operandStack.push(operandStack.pop() + operandStack.pop());
                        } else {
                            operandStack.push(-operandStack.pop() + operandStack.pop());
                        }
                    }
                    operatorStack.pop();
                    break;
                default:
                    operandStack.push(Integer.parseInt(Character.toString(ch)));
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.pop() == '+') {
                operandStack.push(operandStack.pop() + operandStack.pop());
            } else {
                operandStack.push(operandStack.pop() - operandStack.pop());

            }
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("2-1+2"));
    }
}

/*
 * temp : don't wanna delete
 * s = s.replaceAll("[(]+|[)]+|\\s+", "");
 * int result = 0;
 * int currentNumber = 0;
 * int sign = 1;
 * 
 * for (char c : s.toCharArray()) {
 * if (Character.isDigit(c)) {
 * 
 * currentNumber = currentNumber * 10 + (c - '0');
 * } else if (c == '+') {
 * result += sign * currentNumber;
 * currentNumber = 0;
 * sign = 1; // Set the sign back to positive
 * } else if (c == '-') {
 * result += sign * currentNumber;
 * currentNumber = 0;
 * sign = -1; // Set the sign to negative
 * }
 * }
 * result += sign * currentNumber;
 * 
 * return result;
 */