import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, Integer> map = new HashMap<>(); // 차번호 : 누적 주차 시간
    Map<String, String> temp = new HashMap<>(); // 차번호 : 입차 시간

    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (String str : records) {
            var arr = str.split(" ");
            var time = arr[0];
            var carNum = arr[1];
            var isIn = (Objects.equals(arr[2], "IN"));

            if (isIn) {
                temp.put(carNum, time);
                continue;
            }

            addTimeToMap(carNum, temp.get(carNum), time);
        }

        Set<String> lefted = temp.keySet();

        for (String str : lefted) {

            if(!(temp.get(str)==null)){
                addTimeToMap(str, temp.get(str), "23:59");
            }

        }


        List<String> carNums = map.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (String str : carNums) {
            int price = fees[1];

            if (map.get(str) <= fees[0]) {
                answer.add(price);
                continue;
            }

            price += (int) (Math.ceil((double) (map.get(str) - fees[0]) / fees[2]) * fees[3]);
            answer.add(price);
        }

        return answer;
    }

    private void addTimeToMap(String carNum, String inTime, String outTime) {
        int hours = Integer.parseInt(outTime.split(":")[0]) - Integer.parseInt(inTime.split(":")[0]);
        int minutes = Integer.parseInt(outTime.split(":")[1]) - Integer.parseInt(inTime.split(":")[1]);
        int sum = minutes + 60 * hours;

        if (map.containsKey(carNum)) {
            sum += map.get(carNum);
        }

        map.put(carNum, sum);
        temp.put(carNum, null);
    }
}