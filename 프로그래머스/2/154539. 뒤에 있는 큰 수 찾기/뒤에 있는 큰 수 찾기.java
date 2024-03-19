import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {

        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = numbers.length-1; i>-1; i--){

            while (!stack.empty() && numbers[i] >= stack.peek()){
                stack.pop();
            }

            if(!stack.empty()){
                result[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return result;
    }
}