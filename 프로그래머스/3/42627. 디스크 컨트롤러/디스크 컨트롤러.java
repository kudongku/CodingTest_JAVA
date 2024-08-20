import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int solution(int[][] jobs) {
        PriorityQueue<Job> pqRequest = new PriorityQueue<>(new RequestTimeComparator());
        PriorityQueue<Job> pqRequire = new PriorityQueue<>(new RequireTimeComparator());
        int time = 0;
        int totalWaitingTime = 0;

        for (int[] job : jobs) {
            pqRequest.add(new Job(job[0], job[1]));
        }

        while (!pqRequest.isEmpty() || !pqRequire.isEmpty()) {

            while (!pqRequest.isEmpty() && pqRequest.peek().requestTime <= time) {
                pqRequire.offer(pqRequest.poll());
            }

            if (!pqRequire.isEmpty()) {
                Job job = pqRequire.poll();
                time += job.requireTime;
                totalWaitingTime += (time - job.requestTime);
            } else {
                time = pqRequest.peek().requestTime;
            }
        }

        // 평균 대기 시간 계산
        return totalWaitingTime / jobs.length;
    }

    static class Job {

        int requestTime;
        int requireTime;

        public Job(int requestTime, int requireTime) {
            this.requestTime = requestTime;
            this.requireTime = requireTime;
        }
    }

    static class RequireTimeComparator implements Comparator<Job> {

        @Override
        public int compare(Job job1, Job job2) {
            return Integer.compare(job1.requireTime, job2.requireTime);
        }

    }

    static class RequestTimeComparator implements Comparator<Job> {

        @Override
        public int compare(Job job1, Job job2) {
            return Integer.compare(job1.requestTime, job2.requestTime);
        }

    }
}
