import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        for (int j : lost) {
            students[j-1]--;
        }

        for (int k : reserve) {
            students[k-1]++;
        }

        for (int i = 0; i < students.length; i++) {

            if (i != 0 && students[i] > 0 && students[i - 1] < 0) {
                students[i]--;
                students[i - 1]++;
            }

            if (i != n-1 && students[i] > 0 && students[i + 1] < 0) {
                students[i]--;
                students[i + 1]++;
            }

        }

        int answer = 0;

        for (int i = 0; i < students.length; i++) {

            if (students[i] >= 0) {
                answer++;
            }

        }

        return answer;
    }
}