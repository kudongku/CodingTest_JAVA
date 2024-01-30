import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, ArrayList<String>> complaintMap = new HashMap<>(); // {피신고자 : 신고자리스트}

        for(String username : id_list){
            complaintMap.put(username, new ArrayList<String>());
        } // 모든 유저를 넣어줌

        for(String reportStr : report){
            String reporter = reportStr.split(" ")[0]; // 신고자
            String reportee = reportStr.split(" ")[1]; // 피신고자

            if(!complaintMap.get(reportee).contains(reporter)){ // 피신고자의 신고자리스트에 없을 경우,
                complaintMap.get(reportee).add(reporter);
            }
        }

        int[] answer = new int[id_list.length];

        for(String username : complaintMap.keySet()){
            
            if(complaintMap.get(username).size()>=k){
                
                for(String reporter : complaintMap.get(username)){
                    
                    for(int i=0; i<id_list.length; i++){
                        if(reporter.equals(id_list[i])){
                            answer[i]++;
                            break;
                        }
                    }
                }
                
            }
            
        }

        return answer;
    }
}