import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : citations){
            list.add(i);
        }

        List<Integer> citationList = list.stream().sorted().collect(Collectors.toList());

        int answer=0;

        for(int h =0; h<citationList.get(citationList.size()-1); h++){
            int countMore = 0;
            int countLess = 0;

            for(int i: citationList){
                if(h<=i){
                    countMore++;
                }else{
                    countLess++;
                }
            }

            if(h<=countMore && h>countLess){
                answer = h;
            }

        }

        return answer;
    }
}