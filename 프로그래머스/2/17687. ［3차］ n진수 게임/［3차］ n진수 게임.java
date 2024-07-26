class Solution {

    public String solution(int n, int t, int m, int p) {
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int pointer = 0;

        for (int i = p-1; answer.length()<t; i += m) {

            while(strBuilder.length()<i+1){
                strBuilder.append(Integer.toString(pointer++, n));
            }

            answer.append(strBuilder.substring(i, i + 1));
        }

        return answer.toString().toUpperCase();
    }
}