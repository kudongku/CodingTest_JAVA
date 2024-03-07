import java.util.ArrayList;
import java.util.Objects;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        
        ArrayList<Integer[]> candidates = new ArrayList<>();

        if (h < n - 1) {
            Integer[] temp = {h+1, w};
            candidates.add(temp);
        }

        if (w < n - 1) {
            Integer[] temp = {h, w+1};
            candidates.add(temp);
        }

        if (h > 0) {
            Integer[] temp = {h-1, w};
            candidates.add(temp);
        }

        if (w > 0) {
            Integer[] temp = {h, w-1};
            candidates.add(temp);
        }

        String color = board[h][w];

        for(Integer[] arr : candidates){
            if(Objects.equals(board[arr[0]][arr[1]], color)){
                answer++;
            }
        }

        return answer;
    }
}