import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int i=0; i<skip.length(); i++){
            if(alphabet.indexOf(skip.charAt(i))!=-1){
                alphabet = alphabet.replaceAll(String.valueOf(skip.charAt(i)), "");
            }
        }


        System.out.println(alphabet);
        alphabet = alphabet.repeat(5);
        System.out.println(alphabet);
        

        for(int i=0; i<s.length(); i++){
            char target = s.charAt(i);
            int targetIdx = alphabet.indexOf(target);
            answer+=alphabet.charAt(targetIdx+ index);
        }


        return answer;
    }
}