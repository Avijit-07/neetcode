class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(isOperator(token)) {
                int second = stack.pop();
                int first = stack.pop();
                int result = applyOperator(first, second, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private int applyOperator(int first, int second, String token) {
        switch(token) {
        case "+" : return first + second;
        case "-" : return first - second;
        case "*" : return first * second;
        case "/" : return first / second;
        default: throw new RuntimeException("Invalid operator");
        }
    }
}
