class Solution {

    public int solution(int[][] sizes) {
        int bigger = 0;
        int smaller = 0;

        for (int[] i : sizes) {
 
            if (Math.max(i[0], i[1]) > bigger) {
                bigger = Math.max(i[0], i[1]);
            }

            if (Math.min(i[0], i[1]) > smaller) {
                smaller = Math.min(i[0], i[1]);
            }

        }

        return bigger * smaller;
    }
}