import java.util.Stack;

class Solution {

    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        // 각 전선을 끊어가며 최소 차이를 계산
        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            Stack<Integer> stack = new Stack<>();
            stack.push(1);  // 임의의 노드(1번 노드)를 시작점으로 선택
            visited[1] = true;
            int count = 0;

            // DFS 탐색 시작
            while (!stack.isEmpty()) {
                int current = stack.pop();
                count++;

                for (int[] wire : wires) {
                    if (wire == wires[i]) {
                        // 현재 전선을 제거할 경우 건너뜁니다.
                        continue;
                    }

                    if (wire[0] == current && !visited[wire[1]]) {
                        stack.push(wire[1]);
                        visited[wire[1]] = true;
                    } else if (wire[1] == current && !visited[wire[0]]) {
                        stack.push(wire[0]);
                        visited[wire[0]] = true;
                    }
                }
            }

            // 두 네트워크의 차이 계산
            int otherCount = n - count;
            int gap = Math.abs(count - otherCount);
            min = Math.min(min, gap);
        }

        return min;
    }

}
