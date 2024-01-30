class Solution {
    public String solution(String s) {
        String[] numberArr = s.split(" ");
        int max = Integer.parseInt(numberArr[0]);
        int min = Integer.parseInt(numberArr[0]);
        
        for(String num : numberArr){
            int number = Integer.parseInt(num);
            
            if(number>max){
                max = number;
            }

            if(number<min){
                min = number;
            }
            
        }
        
        return min + " " + max;
    }
}