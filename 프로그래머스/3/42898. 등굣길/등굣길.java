import java.util.Arrays;

class Solution {

    public long solution(int m, int n, int[][] puddles) {
        long[][] arr = new long[n][m];

        for (int[] temp : puddles) {
            arr[temp[1] - 1][temp[0] - 1] = -1;
        }

        arr[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (arr[i][j] == -1) {
                    continue;
                }

                if (!(j == 0 || arr[i][j - 1] == -1)) {
                    arr[i][j] += arr[i][j - 1];
                }

                if (!(i == 0 || arr[i - 1][j] == -1)) {
                    arr[i][j] += arr[i - 1][j];
                }

                arr[i][j] %= 1000000007;

            }

            // System.out.println(Arrays.toString(arr[i]));

        }

        return arr[n-1][m-1] % 1000000007;
    }
}