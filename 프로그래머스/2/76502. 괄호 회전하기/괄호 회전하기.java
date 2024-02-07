import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayList<Character> sList = new ArrayList<>();
        char[] sChar = s.toCharArray();
        for(char c : sChar){
            sList.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> sStack = new Stack<>();

            for (char c : sList) {

                if(sStack.isEmpty()){
                    sStack.push(c);
                    continue;
                }

                if ((c == '}') && sStack.get(sStack.size() - 1) == '{') {
                    sStack.pop();
                } else if (c == ']' && sStack.get(sStack.size() - 1) == '[') {
                    sStack.pop();
                } else if (c == ')' && sStack.get(sStack.size() - 1) == '(') {
                    sStack.pop();
                }else{
                    sStack.push(c);
                }

            }

            if(sStack.isEmpty()){
                answer++;
            }

            Character temp = sList.get(0);
            sList.remove(0);
            sList.add(temp);
        }
        return answer;
    }
}