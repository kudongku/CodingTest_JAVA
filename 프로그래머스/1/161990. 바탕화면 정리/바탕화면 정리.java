class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i=0; i<wallpaper.length; i++){
            String str = wallpaper[i];
            char[] charArr = str.toCharArray();

            for(int j=0; j<charArr.length; j++){
                char c = charArr[j];

                if(c=='#'){

                    if(answer[0]>i){
                        answer[0]=i;
                    }
                    if(answer[2]<i){
                        answer[2]=i;
                    }
                    if(answer[1]>j){
                        answer[1]=j;
                    }
                    if(answer[3]<j){
                        answer[3]=j;
                    }

                }

            }

        }

        answer[2]++;
        answer[3]++;
        return answer;
    }
}