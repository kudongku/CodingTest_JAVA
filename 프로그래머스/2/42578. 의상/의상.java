import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1];

            if (clothesMap.containsKey(key)) {
                int temp = clothesMap.get(key);
                clothesMap.put(key, ++temp);
            } else {
                clothesMap.put(key, 1);
            }

        }

        int answer = 1;

        for(Integer i : clothesMap.values()){
            answer=answer*(i+1);
        }

        return answer-1;
    }
}