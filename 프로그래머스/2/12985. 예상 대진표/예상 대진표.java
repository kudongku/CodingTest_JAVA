class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {

            a = (a==((a/2)*2))? a/2 : a/2+1;
            b = (b==((b/2)*2))? b/2 : b/2+1;


            answer++;

            if(a==b){
                return answer;
            }

        }

    }
}