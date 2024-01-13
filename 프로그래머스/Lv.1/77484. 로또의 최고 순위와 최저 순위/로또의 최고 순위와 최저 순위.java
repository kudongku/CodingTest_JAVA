import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] grade = new int[7];
        grade[6] = 1;
        grade[5] = 2;
        grade[4] = 3;
        grade[3] = 4;
        grade[2] = 5;
        grade[1] = 6;
        grade[0] = 6;
        
        ArrayList<Integer> win_numsList = new ArrayList<>();
        ArrayList<Integer> lottoLeft = new ArrayList<>();

        for(int j : win_nums){
            win_numsList.add(j);
        }

        for(int i: lottos){
            if(!win_numsList.contains(i)){
                lottoLeft.add(i);
            }
        }

        int matchCount = lottos.length - lottoLeft.size();
        int matchCountMax = matchCount;

        for(int i : lottoLeft){

            if(i==0){
                matchCountMax++;
            }

        }

        int[] answer = new int[2];
        answer[0] = grade[matchCountMax];
        answer[1] = grade[matchCount];

        return answer;
    }
}