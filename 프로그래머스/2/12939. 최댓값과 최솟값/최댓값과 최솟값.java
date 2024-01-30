class Solution {
     public String solution(String str) {
        String result="";
        String [] blank = str.split(" "); 

        int max, min;
        max = Integer.parseInt(blank[0]);
        min = max;
        for (int i=0; i<blank.length; i++){ 
            if(Integer.parseInt(blank[i])>max){
                max = Integer.parseInt(blank[i]);
            }
            if(Integer.parseInt(blank[i])<min){
                min = Integer.parseInt(blank[i]);
            }
        }
        result = min+" "+max;
        return result;
    }
}