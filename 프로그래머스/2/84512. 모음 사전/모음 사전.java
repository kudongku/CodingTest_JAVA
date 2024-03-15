class Solution {
    int answer = 0;
    char[] chars = new char[]{'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        char[] wordCharArr = word.toCharArray();

        for (int i = 0; i < wordCharArr.length; i++) {

            if (wordCharArr[i] == 'A') {
                answer++;
                continue;
            }

            addNumberOfCases(i, wordCharArr[i]);
        }

        return answer;
    }

    private void addNumberOfCases(int i, char c) {
        int repeatTime = 0;

        for (int j = 0; j < chars.length; j++) {

            if (chars[j] == c) {
                repeatTime = j;
            }

        }

        for (int k = 0; k < repeatTime; k++) {
            switch (i) {
                case 0:
                    answer += 781;
                    break;
                case 1:
                    answer += 156;
                    break;
                case 2:
                    answer+=31;
                    break;
                case 3:
                    answer+=6;
                    break;
                default:
                    answer+=1;
                    break;
            }
        }
        
        answer++;
    }
}