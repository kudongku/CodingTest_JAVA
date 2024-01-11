class Solution {
    public int[] solution(int[] answers) {
        int[][] ways = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};

        int[] score = {0,0,0};

        for(int i=0; i<answers.length; i++){
            if(answers[i]==ways[0][i%5]){
                score[0]++;
            }
            if(answers[i]==ways[1][i%8]){
                score[1]++;
            }
            if(answers[i]==ways[2][i%10]){
                score[2]++;
            }
        }

        int max =0;

        for(int i: score){
            if(i>=max){
                max = i;
            }
        }

        int count = 0;
        for(int i: score){
            if(i==max){
               count++;
            }
        }
        int[] answer = new int[count];

        int pointer =0;

        for(int i=0; i< score.length; i++){
            if(score[i]==max){
                answer[pointer++]=i+1;
            }
        }
        return answer;
    }
}