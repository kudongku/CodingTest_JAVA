import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rank_player = new HashMap<>(); // key = 등수, value = 플레이어
        Map<String, Integer> player_rank = new HashMap<>(); // key = 플레이어, value = 등수

        for (int i = 0; i < players.length; i++) {
            rank_player.put(i, players[i]);
            player_rank.put(players[i], i);
        }
        
        for(String str : callings){ // str = 추월한 선수
            int strRank = player_rank.get(str); // strRank = 추월한 선수의 등수
            String losePlayer = rank_player.get(strRank-1); // losePlayer = 추월당한 선수
            
            player_rank.put(str,strRank-1);
            player_rank.put(losePlayer,strRank);

            rank_player.put(strRank-1, str);
            rank_player.put(strRank, losePlayer);
        }
        
        String[] answer = new String[players.length];
        
        for(int i=0; i<players.length; i++){
            answer[i] = rank_player.get(i);
        }
        
        return answer;
    }
}