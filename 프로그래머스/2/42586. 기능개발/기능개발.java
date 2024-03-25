import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int idxPointer = 0;

        while (true) {
            int countProgress = 0;

            for (int i = idxPointer; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            for (int i = idxPointer; i < progresses.length; i++) {
                
                if(progresses[i]>=100){
                    idxPointer = i+1;
                    countProgress++;
                }else{
                    break;
                }
                
            }

            if(countProgress!=0){
                arr.add(countProgress);
            }

            if(idxPointer == progresses.length){
                return arr;
            }

        }

    }
}