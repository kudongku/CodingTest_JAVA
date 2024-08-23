import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int solution(int[] priorities, int location) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i : priorities) {
            list.add(i);
            queue.add(i);
        }

        list.sort(Collections.reverseOrder());

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            location--;

            if (list.get(count) == temp) {
                count++;

                if (location < 0) {
                    break;
                }

                continue;
            }

            queue.offer(temp);

            if (location < 0) {
                location = queue.size() - 1;
            }

        }

        return count;
    }
}