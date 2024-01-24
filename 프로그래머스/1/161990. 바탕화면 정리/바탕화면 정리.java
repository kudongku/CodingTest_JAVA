class Solution {
    public int[] solution(String[] wallpaper) {
        int left=127;
        int right=-1;
        int top=127;
        int bottom=-1;

        for(int i=0; i<wallpaper.length; i++){
           String str = wallpaper[i];
           char[] charArr = str.toCharArray();

           for(int j=0; j<charArr.length; j++){
               char c = charArr[j];

               if(c=='#'){

                   if(top>i){
                       top=i;
                   }
                   if(bottom<i){
                       bottom=i;
                   }
                   if(left>j){
                       left=j;
                   }
                   if(right<j){
                       right=j;
                   }

               }

           }

        }

        int[] answer = {top, left, bottom+1, right+1};
        return answer;
    }
}