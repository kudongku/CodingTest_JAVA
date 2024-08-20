import java.util.PriorityQueue;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a + 2 * b;
            pq.add(c);
            answer++;
        }

        if (pq.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}
