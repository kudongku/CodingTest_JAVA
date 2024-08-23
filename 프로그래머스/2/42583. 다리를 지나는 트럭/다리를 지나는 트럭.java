import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int seconds = 0;
        int totalWeight = 0;
        Queue<Truck> bridgeQ = new LinkedList<>();
        Queue<Truck> waitQ = new LinkedList<>();

        for (int truck : truck_weights) {
            waitQ.offer(new Truck(truck));
        }

        while (!waitQ.isEmpty() || !bridgeQ.isEmpty()) {
            seconds++;

            if (!bridgeQ.isEmpty() &&
                seconds - bridgeQ.peek().aboardTime >= bridge_length
            ) {
                Truck truck = bridgeQ.poll();
                totalWeight -= truck.weight;
            }

            if (!waitQ.isEmpty() &&
                weight >= totalWeight + waitQ.peek().weight
            ) {
                Truck truck = waitQ.poll();
                truck.aboardTime = seconds;
                bridgeQ.offer(truck);
                totalWeight += truck.weight;
            }

        }

        return seconds;
    }

    static class Truck {

        int weight;
        int aboardTime;

        public Truck(int weight) {
            this.weight = weight;
        }
    }
}