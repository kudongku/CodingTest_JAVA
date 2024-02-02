class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {

            if (a == ((a/2)*2)){
                a = a/2;
            } else {
                a = a/2+1;
            }

            if (b == ((b/2)*2)){
                b = b/2;
            } else {
                b = b/2+1;
            }

            answer++;

            if(a==b){
                return answer;
            }
        }

    }
}