import java.util.Arrays;
import java.util.Stack;

class Solution {

    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            int count = 0;
            
            for (int j = 1; j <= n; j++) {
                
                if (!visited[j]) {
                    int subCount = dfs(j, visited, wires, i);
                    count = Math.max(count, subCount);
                }
                
            }

            int otherCount = n - count;
            int gap = Math.abs(count - otherCount);
            min = Math.min(min, gap);
        }

        return min;
    }

    private int dfs(int start, boolean[] visited, int[][] wires, int skip) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;

            for (int[] wire : wires) {
                if (Arrays.equals(wire, wires[skip])) continue; // 특정 전선은 무시합니다.

                if (wire[0] == current && !visited[wire[1]]) {
                    stack.push(wire[1]);
                    visited[wire[1]] = true;
                } else if (wire[1] == current && !visited[wire[0]]) {
                    stack.push(wire[0]);
                    visited[wire[0]] = true;
                }
            }
        }

        return count;
    }

}
