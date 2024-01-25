import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        String[] todayArr = today.split("\\.");

        Map<String, String> termMap = new HashMap<>();
        for (String str : terms) {
            termMap.put(str.split(" ")[0], str.split(" ")[1]);
        }

        String[][] privaciesArr = new String[privacies.length][];
        for (int i = 0; i < privaciesArr.length; i++) {
            privaciesArr[i] = privacies[i].split(" ");
        }


        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<privaciesArr.length; i++){
            String[] strArr = privaciesArr[i];
            int leftMonth = 0;
            String[] privacyDay = strArr[0].split("\\.");

            leftMonth+=(Integer.parseInt(todayArr[0])-Integer.parseInt(privacyDay[0]))*12;
            leftMonth+=(Integer.parseInt(todayArr[1])-Integer.parseInt(privacyDay[1]));

            if(leftMonth>Integer.parseInt(termMap.get(strArr[1]))){
                answer.add(i+1);
            }else if(leftMonth==Integer.parseInt(termMap.get(strArr[1]))){
                if(Integer.parseInt(todayArr[2])>=Integer.parseInt(privacyDay[2])){
                    answer.add(i+1);
                }
            }

        }

        return answer;
    }
}