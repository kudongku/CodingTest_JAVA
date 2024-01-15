import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public String solution(String X, String Y) {
        int[] intArrX = {0,0,0,0,0,0,0,0,0,0};
        int[] intArrY = {0,0,0,0,0,0,0,0,0,0};

        char[] XcharArr = X.toCharArray();
        char[] YcharArr = Y.toCharArray();

        for(char c : XcharArr){
            intArrX[Integer.parseInt(String.valueOf(c))]++;
        }

        for(char c : YcharArr){
            intArrY[Integer.parseInt(String.valueOf(c))]++;
        }

        int[] temp = {0,0,0,0,0,0,0,0,0,0};

        boolean isNothing = true;

        for(int i=0; i< intArrX.length; i++){

            if(intArrX[i]!=0&&intArrY[i]!=0){
                isNothing=false;

                if(intArrX[i]<intArrY[i]){
                    temp[i]=intArrX[i];
                }else{
                    temp[i]=intArrY[i];
                }

            }

        }

        boolean isOnlyZero = true;

        StringBuilder answer = new StringBuilder();

        for(int i=temp.length-1; i>=0; i--){

            if(i!=0&&temp[i]>0){
                isOnlyZero=false;
            }

            for(int j=0; j<temp[i]; j++){
                answer.append(i);
            }
            
        }
        
        if(isNothing){
            return "-1";
        }

        if(isOnlyZero){
            return "0";
        }
        
        return answer.toString();
    }
}