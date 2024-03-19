import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 하루에 한번씩 검증
        for (int i = 0; i < discount.length-9; i++) {
            // tempMap = {want:number}
            Map<String, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < want.length; j++) {
                tempMap.put(want[j], number[j]);
            }

            // 오늘 할인 제품이 원하는 제품일 경우
            if (tempMap.containsKey(discount[i])) {
                // 오늘부터 10개만 잘라서 가져옴
                for (int k=i; k<i+10; k++) {
                    String str = discount[k];

                    if (tempMap.containsKey(str)) {
                        int tempInt = tempMap.get(str);
                        tempInt--;
                        tempMap.put(str, tempInt);
                    }

                }

                answer++;

                for (Integer a : tempMap.values()) {

                    if (a != 0) {
                        answer--;
                        break;
                    }

                }

            }

        }

        return answer;
    }
}