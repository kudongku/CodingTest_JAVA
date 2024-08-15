import java.util.Stack;

class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        boolean[] isStacked = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < isVisited.length; i++) {

            if (!isVisited[i]) {
                stack.push(i);
                isStacked[i] = true;
                answer++;

                while (!stack.isEmpty()) {
                    int temp = stack.pop();
                    isVisited[temp] = true;

                    for (int j = 0; j < computers.length; j++) {

                        if (computers[temp][j] == 1 && 
                            !isStacked[j] &&
                            j!=temp
                        ) {
                            stack.push(j);
                            isStacked[j] = true;
                        }

                    }

                }

            }

        }

        return answer;
    }
}