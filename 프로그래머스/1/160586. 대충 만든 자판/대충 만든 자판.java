import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> answers = new ArrayList<>();

        for (String str : targets) {
            char[] tempArr = str.toCharArray();
            int sum = 0;

            for (char c : tempArr) {
                int minIdx = -1;

                for (String key : keymap) {
                    int keyIndexOfC = key.indexOf(c);

                    if (keyIndexOfC != -1 && (minIdx == -1 || minIdx > keyIndexOfC)) {
                        minIdx = keyIndexOfC + 1;
                    }

                }

                if (minIdx == -1) {
                    sum = -1;
                    break;
                } else {
                    sum+=minIdx;
                }

            }
            
            answers.add(sum);

        }

        return answers;
    }
}