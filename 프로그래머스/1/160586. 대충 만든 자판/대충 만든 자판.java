import java.util.ArrayList;
import java.util.List;

class Solution {
    public  List<Integer> solution(String[] keymap, String[] targets) {
         // return value
        List<Integer> answer = new ArrayList<>();

        //targets 를 순회 하며, 각 원소에 맞는 값을 answer 에 add
        for(String str : targets){

            //target 의 원소를 char 배열로
            char[] target = str.toCharArray();
            // 각 char 배열을 입력 하는 총 입력 수
            int sum = 0;

            //char 배열을 순회
            for(char c : target){

                // keyMap 의 가장 작은 인덱스 를 저장할 값
                int minIdx = -1;

                //keyMap 순회
                for(String key : keymap){

                    if(key.indexOf(c)!=-1){

                        if(minIdx==-1){
                            minIdx=key.indexOf(c)+1;
                        }else if(minIdx>key.indexOf(c)+1){
                            minIdx=key.indexOf(c)+1;
                        }

                    }

                }
                
                if(sum!=-1){
                    
                    if(minIdx==-1){
                        sum=-1;
                    }else{
                        sum+=minIdx;
                    }
                    
                }

            }

            answer.add(sum);

        }

        return answer;
    }
}