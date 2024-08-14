import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 이동 방향
        int[] dy = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작 지점 추가 (x, y, 거리)
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == n - 1 && y == m - 1) {
                return distance; // 목적지에 도착하면 거리 반환
            }

            // 4가지 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, distance + 1});
                    visited[nx][ny] = true; // 방문 체크
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
