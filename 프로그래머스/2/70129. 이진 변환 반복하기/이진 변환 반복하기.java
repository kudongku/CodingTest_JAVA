class Solution {
    public int[] solution(String s) {
        int[] returnValue = new int[]{0, 0};

        while (!s.equals("1")) {
            String zeroRemoved = s.chars()
                    .filter(c -> c != '0')
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            int addValue = s.length() - zeroRemoved.length();

            if (addValue != 0) {
                returnValue[1] += addValue;
            }

            returnValue[0]++;
            s = Integer.toBinaryString(zeroRemoved.length());
        }

        return returnValue;
    }
}