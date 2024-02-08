import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> intSet = new HashSet<>();
        ArrayList<Integer> eList = new ArrayList<>();

        for(int i : elements){
            eList.add(i);
        }

        for(int i : elements){
            eList.add(i);
        }

        for (int count = 1; count <= elements.length; count++) {

            for (int pointer = 0; pointer < elements.length; pointer++) {
                int sum = 0;
                int i = 0;
                int pointer2 = pointer;

                while (i < count) {
                    sum+=eList.get(pointer2);
                    pointer2++;
                    i++;
                }

                intSet.add(sum);
            }

        }

        return intSet.size();
    }
}