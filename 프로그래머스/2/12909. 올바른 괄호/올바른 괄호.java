import java.util.Stack;

class Solution {

    boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);

            if (stack.isEmpty()) {
                stack.push(temp);
                continue;
            }

            if (stack.peek().equals("(") && temp.equals(")")) {
                stack.pop();
                continue;
            }

            stack.push(temp);
        }
        
        return stack.isEmpty();
    }
}