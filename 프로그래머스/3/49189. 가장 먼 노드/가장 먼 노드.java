import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int solution(int n, int[][] edge) {
        int maxValue = 0;
        int count = 0;

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] arr : edge) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.value > maxValue) {
                maxValue = currentNode.value;
                count = 0;
            }

            if (currentNode.value == maxValue) {
                count++;
            }

            List<Integer> nodes = list.get(currentNode.n);

            for (int i : nodes) {

                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, currentNode.value + 1));
                }

            }

        }

        return count;
    }

    static class Node {

        int n;
        int value;

        public Node(int n, int value) {
            this.n = n;
            this.value = value;
        }
    }
}