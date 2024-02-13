import java.util.ArrayList;

class Solution {
    public ArrayList<Long> solution(int n, long left, long right) {
        ArrayList<Long> answer = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            long iDevidedN = i / n;
            long pointer = i % n;

            if(pointer<=iDevidedN){
                answer.add(iDevidedN+1);
            }else{
                answer.add(pointer+1);
            }
        }

        return answer;
    }
}