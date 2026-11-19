class Solution {
    public String operation(String c, ArrayDeque<String> stack) {
        int result = 0;
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        switch (c) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            default: result = 0;
        }
        return String.valueOf(result);
    }

    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String item: tokens) {
            if (item.equals("+") || item.equals("-") 
            || item.equals("*") || item.equals("/")) {
                stack.push(operation(item, stack));
            } else {
                stack.push(item);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}