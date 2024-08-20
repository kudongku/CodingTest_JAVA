import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            String a= str.split(" ")[0];
            String b= str.split(" ")[1];

            if(a.equals("I")){
                pq.offer(Integer.parseInt(b));
                pqReverse.offer(Integer.parseInt(b));
                continue;
            }

            if(b.startsWith("-") && !pq.isEmpty()){
                int i = pq.poll();
                pqReverse.remove(i);
                continue;
            }

            if(!pqReverse.isEmpty()){
                int i = pqReverse.poll();
                pq.remove(i);
            }
            
        }

        if(pq.isEmpty()){
            return new int[]{0,0};
        }

        return new int[]{pqReverse.poll(),pq.poll()};
    }
}