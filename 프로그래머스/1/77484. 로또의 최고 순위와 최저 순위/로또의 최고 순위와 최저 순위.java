import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] grade = new int[]{6,6,5,4,3,2,1};

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

        return new int[]{grade[matchCountMax], grade[matchCount]};
    }
}