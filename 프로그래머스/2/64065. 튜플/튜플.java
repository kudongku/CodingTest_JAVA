import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int[] solution(String s) {
        String sSubstring = s.substring(2, s.length() - 2);
        String[] sArray = sSubstring.split("},\\{");
        int[][] sArraySorted = new int[sArray.length][];
        Set<Integer> set = new HashSet<>();

        for (String atom : sArray) {
            int[] tempArr = Arrays.stream(atom.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
            sArraySorted[tempArr.length - 1] = tempArr;
        }

        for (int i : sArraySorted[sArraySorted.length-1]) {
            set.add(i);
        }

        System.out.println(set);

        int[] answer = new int[set.size()];
        int pointer = 0;

        for(int[] iArr : sArraySorted){
            for(int i : iArr){
                if(set.contains(i)){
                    answer[pointer] = i;
                    pointer++;
                    set.remove(i);
                }
            }
        }
        return answer;
    }
}