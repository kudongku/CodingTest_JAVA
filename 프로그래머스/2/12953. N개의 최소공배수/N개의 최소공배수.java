class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        boolean flag = true;

        while(flag){
            flag = false;
            
            for(int i : arr){
                
                if(!(answer%i==0)){
                    answer++;
                    flag = true;
                }
                
            }
            
        }

        return answer;
    }
}