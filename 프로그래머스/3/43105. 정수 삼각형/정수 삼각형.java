import java.util.Arrays;

class Solution {

    public int solution(int[][] triangle) {
        int[][] arr = new int[triangle.length][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[triangle[i].length];
            System.arraycopy(triangle[i], 0, arr[i], 0, triangle[i].length);
        }

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                int temp = arr[i][j];
                int a = triangle[i + 1][j] + temp;
                int b = triangle[i + 1][j + 1] + temp;

                if (a > arr[i + 1][j]) {
                    arr[i + 1][j] = a;
                }

                if (b > arr[i + 1][j + 1]) {
                    arr[i + 1][j + 1] = b;
                }

            }

        }

        int answer = 0;

        for (int i = 0; i < arr[arr.length - 1].length; i++) {

            if (arr[arr.length - 1][i] > answer) {
                answer = arr[arr.length - 1][i];
            }

        }

        return answer;
    }
}