import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
            Map<Character, Integer> score = new HashMap<>();

        for(int i=0; i<survey.length; i++){
            Character a = survey[i].charAt(0);
            Character b = survey[i].charAt(1);

            switch(choices[i]){
                case 1:
                    if(score.containsKey(a)){
                        int temp = score.get(a);
                        temp+=3;
                        score.remove(a);
                        score.put(a,temp);
                    }else{
                        score.put(a,3);
                    }
                    break;
                case 2:
                    if(score.containsKey(a)){
                        int temp = score.get(a);
                        temp+=2;
                        score.remove(a);
                        score.put(a,temp);
                    }else{
                        score.put(a,2);
                    }
                    break;
                case 3:
                    if(score.containsKey(a)){
                        int temp = score.get(a);
                        temp+=1;
                        score.remove(a);
                        score.put(a,temp);
                    }else{
                        score.put(a,1);
                    }
                    break;
                case 5:
                    if(score.containsKey(b)){
                        int temp = score.get(b);
                        temp+=1;
                        score.remove(b);
                        score.put(b,temp);
                    }else{
                        score.put(b,1);
                    }
                    break;
                case 6:
                    if(score.containsKey(b)){
                        int temp = score.get(b);
                        temp+=2;
                        score.remove(b);
                        score.put(b,temp);
                    }else{
                        score.put(b,2);
                    }
                    break;
                case 7:
                    if(score.containsKey(b)){
                        int temp = score.get(b);
                        temp+=3;
                        score.remove(b);
                        score.put(b,temp);
                    }else{
                        score.put(b,3);
                    }
                    break;
            }
        }

        String answer = "";

        if(score.containsKey('R')&&score.containsKey('T')){
            if(score.get('R')>=score.get('T')){
                answer+='R';
            }else{
                answer+='T';
            }
        }else if (score.containsKey('R')){
            answer+='R';
        }else if (score.containsKey('T')){
            answer+='T';
        }else{
            answer+='R';
        }

        if(score.containsKey('C')&&score.containsKey('F')){
            if(score.get('C')>=score.get('F')){
                answer+='C';
            }else{
                answer+='F';
            }
        }else if (score.containsKey('C')){
            answer+='C';
        }else if (score.containsKey('F')){
            answer+='F';
        }else{
            answer+='C';
        }

        if(score.containsKey('J')&&score.containsKey('M')){
            if(score.get('J')>=score.get('M')){
                answer+='J';
            }else{
                answer+='M';
            }
        }else if (score.containsKey('J')){
            answer+='J';
        }else if (score.containsKey('M')){
            answer+='M';
        }else{
            answer+='J';
        }

        if(score.containsKey('A')&&score.containsKey('N')){
            if(score.get('A')>=score.get('N')){
                answer+='A';
            }else{
                answer+='N';
            }
        }else if (score.containsKey('A')){
            answer+='A';
        }else if (score.containsKey('N')){
            answer+='N';
        }else{
            answer+='A';
        }

        return answer;
    }
}