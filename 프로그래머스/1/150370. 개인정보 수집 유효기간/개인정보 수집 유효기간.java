import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        String[] todayArr = today.split("\\."); //today = {year, month, day};

        Map<String, Integer> termMap = new HashMap<>(); //termMap = {term:month}
        for (String str : terms) {
            termMap.put(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]));
        }

        String[][] privaciesArr = new String[privacies.length][]; //privaciesArr = {{"year, month, day", term},{"year, month, day", term}};
        for (int i = 0; i < privaciesArr.length; i++) {
            privaciesArr[i] = privacies[i].split(" ");
        }


        ArrayList<Integer> answer = new ArrayList<>(); //returnValue

        for(int i=0; i<privaciesArr.length; i++){
            String[] strArr = privaciesArr[i]; //strArr = {"year, month, day", term};
            int leftdays = 0;
            String[] privacyDay = strArr[0].split("\\."); //privacyDay = {year, month, day}

            leftdays+=(Integer.parseInt(todayArr[0])-Integer.parseInt(privacyDay[0]))*336;
            leftdays+=(Integer.parseInt(todayArr[1])-Integer.parseInt(privacyDay[1]))*28;
            leftdays+=(Integer.parseInt(todayArr[2])-Integer.parseInt(privacyDay[2]));

            if(leftdays>=termMap.get(strArr[1])*28){
                answer.add(i+1);
            }

        }

        return answer;
    }
}