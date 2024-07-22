import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int[] solution(String s) { // s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        String[] sArray = s.substring(2, s.length() - 2).split("},\\{");
        // sArray = [ "2", "2,1", "2,1,3", "2,1,3,4"]

        int[][] sArraySorted = new int[sArray.length][];

        for (String atom : sArray) { // atom = "2,1,3,4"
            int[] tempArr = Arrays.stream(atom.split(",")) // ["2", "1", "3", "4"]
                .mapToInt(Integer::parseInt) // [2,1,3,4]
                .toArray();
            sArraySorted[tempArr.length - 1] = tempArr;
        }
        // sArraySorted = [[1],[1,2],[1,2,3],[1,2,3,4]]

        int[] answer = new int[sArraySorted.length];
        int pointer = 0;
        Set<Integer> set = new HashSet<>();

        for (int[] iArr : sArraySorted) {

            for (int i : iArr) {

                if (!set.contains(i)) {
                    answer[pointer++] = i;
                    set.add(i);
                }

            }

        }

        return answer;
    }
}