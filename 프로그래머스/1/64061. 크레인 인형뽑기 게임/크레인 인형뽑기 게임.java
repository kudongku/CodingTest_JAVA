import java.util.Stack;

class Solution {
    int answer = 0;
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            int idx = i-1;

            for (int[] arr : board) {

                if (arr[idx] != 0) {
                    putIInStack(stack, arr[idx]);
                    arr[idx] = 0;
                    break;
                }

            }

        }

        return answer;
    }

    private void putIInStack(Stack<Integer> stack, int i) {
        if (stack.isEmpty()) {
            stack.push(i);
        } else {
            if (stack.peek() == i) {
                stack.pop();
                answer+=2;
            } else {
                stack.push(i);
            }
        }
    }
}