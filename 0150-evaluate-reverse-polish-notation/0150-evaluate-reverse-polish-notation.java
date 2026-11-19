class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String item: tokens) {
           if (item.equals("+") || item.equals("-") 
            || item.equals("*") || item.equals("/")) {
                int result = 0;
                int b = stack.pop();
                int a = stack.pop();
                switch (item) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;
                    default: break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.pop();
    }
}