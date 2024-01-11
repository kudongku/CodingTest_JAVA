import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int[] newScore = new int[score.length];

        for(int i=score.length-1; i>=0; i--){
            newScore[score.length-1-i] = score[i];
        }


        int count = m;
        int boxPrice = 0;

        for(int i:newScore){
            if(count!=0){
                boxPrice=i;
                count--;
            }
            if(count==0) {
                answer+=(m*boxPrice);
                count=m;
            }
        }

        return answer;
    }
}