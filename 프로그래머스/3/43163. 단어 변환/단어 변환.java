import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(String begin, String target, String[] words) {
        int arrLength = words.length;
        boolean[] isVisited = new boolean[arrLength];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String word = node.getWord();
            char[] wordArr = word.toCharArray();
            int count = node.getCount();

            if (word.equals(target)) {
                return count;
            }

            for (int i = 0; i < arrLength; i++) {

                if (isVisited[i]) {
                    continue;
                }

                if (count != 0 && words[i].equals(word)) {
                    isVisited[i] = true;
                    continue;
                }

                if (isOneLetterDifferent(words[i], wordArr)) {
                    queue.add(new Node(words[i], count + 1));
                }

            }


        }

        return 0;
    }

    private boolean isOneLetterDifferent(String comparatorWord, char[] controlWordArr) {
        char[] comparatorWordArr = comparatorWord.toCharArray();
        int differenceCount = 0;

        for (int i = 0; i < comparatorWord.length(); i++) {

            if (comparatorWordArr[i] != controlWordArr[i]) {
                differenceCount++;
            }

        }

        return differenceCount == 1;
    }

    class Node {

        private final String word;
        private final int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }
    }
}