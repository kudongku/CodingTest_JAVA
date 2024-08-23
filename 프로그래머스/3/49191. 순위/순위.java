import java.util.ArrayList;
import java.util.Stack;

class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> winGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> loseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winGraph.add(i, new ArrayList<>());
            loseGraph.add(i, new ArrayList<>());
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winGraph.get(winner).add(loser);
            loseGraph.get(loser).add(winner);
        }

        for (int i = 1; i <= n; i++) {

            if (countReachable(winGraph, i, n) + countReachable(loseGraph, i, n) == n - 1) {
                answer++;
            }

        }

        return answer;
    }

    private int countReachable(ArrayList<ArrayList<Integer>> graph, int start, int n) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int next : graph.get(node)) {

                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                    count++;
                }

            }

        }

        return count;
    }
}
