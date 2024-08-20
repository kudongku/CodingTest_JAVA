import java.util.Arrays;

class Solution {

    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        long minutes = right;

        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;

            for (int i : times) {
                count += mid / i;
            }

            if (count >= n) {
                minutes = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return minutes;
    }
}