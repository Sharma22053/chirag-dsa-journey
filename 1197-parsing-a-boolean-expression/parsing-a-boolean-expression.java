class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(')
                continue;
            if (ch == 't' || ch == 'f' || ch == '!' || ch == '&' || ch == '|') {
                stack.push(ch);
            } else if (ch == ')') {
                boolean hasTrue = false, hasFalse = false;
                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char top = stack.pop();
                    if(top == 't') hasTrue = true;
                    if(top == 'f') hasFalse = true;
                }
                char operation = stack.pop();
                if(operation == '!') stack.push(hasTrue?'f':'t');
                else if(operation == '&') stack.push(hasFalse?'f':'t');
                else stack.push(hasTrue?'t':'f');
            }
        }
        return stack.peek() == 't';
    }
    
}