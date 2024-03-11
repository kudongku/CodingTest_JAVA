import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentIndex = currentNode.index;
            int currentSum = currentNode.sum;

            if (currentIndex == numbers.length) {
                if (currentSum == target) {
                    count++;
                }
                continue;
            }

            // Include the current number with addition
            queue.add(new Node(currentIndex + 1, currentSum + numbers[currentIndex]));

            // Include the current number with subtraction
            queue.add(new Node(currentIndex + 1, currentSum - numbers[currentIndex]));
        }

        return count;
    }

    private static class Node {
        int index;
        int sum;

        Node(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}