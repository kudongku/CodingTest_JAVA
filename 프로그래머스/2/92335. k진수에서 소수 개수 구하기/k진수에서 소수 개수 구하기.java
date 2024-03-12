import java.util.Objects;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String trit = Integer.toString(n, k);
        String[] tritArr = trit.split("0");

        for (String str : tritArr) {

            if(!str.isEmpty() && !Objects.equals(str, "1") && isDecimal(str)){
                answer++;
            }

        }

        return answer;
    }

    private boolean isDecimal(String str) {

        long num = Long.parseLong(str);

        for(int i=2; i<=Math.sqrt(num); i++){

            if(num%i==0){
                return false;
            }

        }

        return true;
    }
}