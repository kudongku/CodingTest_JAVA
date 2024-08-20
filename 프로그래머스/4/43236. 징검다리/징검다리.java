import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public long solution(int distance, int[] rocks, int n) {
        long left = 1;
        long right = distance;
        long answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : rocks) {
            list.add(i);
        }

        Collections.sort(list);

        while (left <= right) {
            long count = 0;
            long pointer = 0;
            long mid = (left + right) / 2;

            for (int i : list) {

                if (i - pointer < mid) {
                    count++;
                }else{
                    pointer = i;
                }

            }

            if(distance - pointer < mid) {
                count++;
            }

//             System.out.println("count = " + count);
//             System.out.println("left = " + left);
//             System.out.println("right = " + right);
//             System.out.println("mid = " + mid);
//             System.out.println(" ");

            if (count > n) {
                right = mid - 1;
            }else{
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}