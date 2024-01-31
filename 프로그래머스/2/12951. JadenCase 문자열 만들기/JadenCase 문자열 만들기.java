class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] ArrS = s.split(" ");

        for(String str : ArrS){
            char[] ArrChar = str.toCharArray();

            for(int i=0; i< ArrChar.length; i++){
                if(i==0){
                    answer.append(String.valueOf(ArrChar[i]).toUpperCase());
                }else{
                    answer.append(String.valueOf(ArrChar[i]).toLowerCase());
                }
            }

            answer.append(" ");
        }

        return answer.substring(0, s.length());
    }
}