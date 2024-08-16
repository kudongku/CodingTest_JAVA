import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(String begin, String target, String[] words) {
        int arrLength = words.length;
        boolean[] isVisited = new boolean[arrLength];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            String controlWord = currentNode.getWord();
            int count = currentNode.getCount();

            if (controlWord.equals(target)) {
                return count;
            }

            for (int i = 0; i < arrLength; i++) {

                if (!isVisited[i] &&
                    isOneLetterDifferent(words[i], controlWord)
                ) {
                    isVisited[i] = true;
                    queue.add(new Node(words[i], count + 1));
                }

            }

        }

        return 0;
    }

    private boolean isOneLetterDifferent(String comparatorWord, String controlWord) {
        char[] comparatorWordArr = comparatorWord.toCharArray();
        char[] controlWordArr = controlWord.toCharArray();
        int differenceCount = 0;

        for (int i = 0; i < controlWord.length(); i++) {

            if (comparatorWordArr[i] != controlWordArr[i]) {
                differenceCount++;

                if (differenceCount > 1) {
                    break;
                }

            }

        }

        return differenceCount == 1;
    }

    static class Node {

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