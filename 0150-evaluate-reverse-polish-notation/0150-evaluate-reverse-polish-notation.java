class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        String operators = "+-*/";

        for (String item: tokens) {
           if (operators.contains(item)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (item) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    default: break;
                }
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.pop();
    }
}