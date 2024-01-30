import java.util.Arrays;

class Solution {
     public String solution(String str) {
        String[] arrStr = str.split(" ");
        int[] arrInt = new int[arrStr.length];
        int i=0;
        for(String part : arrStr){
          arrInt[i] = Integer.parseInt(part);
          i++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());

        return sb.toString();
    }
}