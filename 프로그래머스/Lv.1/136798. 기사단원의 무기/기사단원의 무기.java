class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            int count = getDivisor(i,limit);

            if(count<=limit){
                answer+=count;
            }else{
                answer+=power;
            }

        }

        return answer;
    }

    private static int getDivisor(int i, int limit) {
        int count = 1;
        for(int j=2; j<=i; j++){
            int temp = 0;

            while(true){
                if(i%j==0){
                    i/=j;
                    temp++;
                }else{
                    break;
                }
            }

            if(temp!=0){
                count*=(temp+1);
            }
        }
        return count;
    }
}