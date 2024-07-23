import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public long solution(String str1, String str2) { // "aB+Cd"
        str1 = toLowerAlphabet(str1);  // "ab+cd"
        str2 = toLowerAlphabet(str2);
        ArrayList<String> str1List = substringTwoLettersEach(str1); // ["ab","cd"]
        ArrayList<String> str2List = substringTwoLettersEach(str2);
        int preStr2ListSize = str2List.size();
        System.out.println("str1List = " + str1List);
        System.out.println("str2List = " + str2List);
        Set<String> strSet = new HashSet<>();
        strSet.addAll(str1List);
        strSet.addAll(str2List);
        int or = 0;

        System.out.println("strSet = " + strSet);

        for (String str : strSet) {
            int a = 0;
            int b = 0;

            for (String i : str1List){
                if(i.equals(str)){
                    a++;
                }
            }

            for (String i : str2List){
                if(i.equals(str)){
                    b++;
                }
            }

            or += Math.max(a, b);

        }

        
        int and = str1List.size() + preStr2ListSize - or;

        if (or == 0) {
            return 65536;
        }

        System.out.println("or = " + or);
        System.out.println("and = " + and);

        double answer = ((double) and / or) * 65536;
        return (long) answer;
    }

    private String toLowerAlphabet(String str) {
        return str.toLowerCase().replaceAll("[^a-z]", " ");
    }

    private ArrayList<String> substringTwoLettersEach(String str) {
        ArrayList<String> strArray = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String temp = str.substring(i, i + 2);

            if (temp.charAt(0) != ' ' && temp.charAt(1) != ' ') {
                strArray.add(temp);
            }

        }

        return strArray;
    }
}