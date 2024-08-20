import java.util.Arrays;

class Solution {

    public long solution(int n, int[] times) {
        long left = 1; // 최소 시간
        long right = Arrays.stream(times).max().getAsInt() * (long) n; // 최대 시간
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long peopleProcessed = 0;

            // 주어진 중간 시간 내에 처리할 수 있는 사람 수 계산
            for (int time : times) {
                peopleProcessed += mid / time;
            }

            if (peopleProcessed >= n) {
                answer = mid; // 모든 사람을 처리할 수 있다면 시간을 줄여서 더 좋은 해를 찾는다
                right = mid - 1;
            } else {
                left = mid + 1; // 모든 사람을 처리할 수 없다면 시간을 늘린다
            }
        }

        return answer;
    }
}
