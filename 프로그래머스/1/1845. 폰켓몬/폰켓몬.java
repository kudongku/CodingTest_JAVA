import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length/2;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i : nums){
            map.putIfAbsent(i, new ArrayList<Integer>());
            map.get(i).add(i);
        }
        
        int counts = map.keySet().size();
        
        if(n>counts){
            return counts;
        }
        
        return n;
    }
}