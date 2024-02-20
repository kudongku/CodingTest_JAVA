import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < discount.length-9; i++) {

            // TODO: 2/20/24 want와 number 섞어서 Map 만들기
            Map<String, Integer> tempMap = new HashMap<>();

            for (int j = 0; j < want.length; j++) {
                tempMap.put(want[j], number[j]);
            }

            // TODO: 2/20/24 i부터 10개를 자름

            if (tempMap.containsKey(discount[i])) {
                String[] temp = new String[10];

                for (int k = i, tempPoint = 0; k < i + 10; k++, tempPoint++) {
                    temp[tempPoint] = discount[k];
                }

                // TODO: 2/20/24 그 10개가 want를 만족시키는지 확인
                for (String str : temp) {

                    if (tempMap.containsKey(str)) {
                        int tempInt = tempMap.get(str);
                        tempInt--;
                        tempMap.put(str, tempInt);
                    }

                }

                boolean flag = true;

                for (Integer a : tempMap.values()) {

                    if (a != 0) {
                        flag = false;
                        break;
                    }

                }

                if (flag) {
                    answer++;
                }

            }


        }

        return answer;
    }
}