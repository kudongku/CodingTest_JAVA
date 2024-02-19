class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int[][] answer = new int[n][m];

        for(int i=0; i<n; i++){
            int[] temp = arr1[i];


            int[] answerRow = new int[m];
            int answerPointer = 0;
            int arr2Pointer = 0;

            for(int j=0; j<m; j++){
                int tempPointer = 0;

                for(int k=0; k<arr2.length; k++){
                    answerRow[answerPointer] += temp[tempPointer]*arr2[k][arr2Pointer];
                    tempPointer++;
                }

                arr2Pointer++;
                answerPointer++;
            }
            answer[i] = answerRow;
        }

        return answer;
    }
}