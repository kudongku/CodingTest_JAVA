class Solution {
    public int solution(String s) {
        int answer = 0;

        int pointer = 0;
        int countFirstLetter = 0;
        int countOtherLetter = 0;
        char firstLetter = 0;

        while(pointer<s.length()){

            if(firstLetter==0){
                firstLetter = s.charAt(pointer);
            }

            if(s.charAt(pointer)==firstLetter){
                countFirstLetter++;
            }

            if(s.charAt(pointer)!=firstLetter){
                countOtherLetter++;
            }

            if(countFirstLetter==countOtherLetter){
                answer++;
                countFirstLetter = 0;
                countOtherLetter = 0;
                firstLetter = 0;
            }

            pointer++;
        }
        
        if(firstLetter!=0){
            answer++;
        }
        
        return answer;
    }
}