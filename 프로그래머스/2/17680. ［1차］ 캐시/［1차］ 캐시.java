import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> cacheQueue = new LinkedList<>();
        Set<String> cacheSet = new HashSet<>();
        int proceedTime = 0;
        
        if(cacheSize==0){
            return cities.length*5;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            if (!cacheSet.contains(city)) {

                if (cacheSet.size() == cacheSize) {
                    cacheSet.remove(cacheQueue.poll());
                }

                cacheSet.add(city);
                proceedTime += 4;
            }else{
                cacheQueue.remove(city);
            }

            cacheQueue.add(city);
            proceedTime += 1;
        }

        return proceedTime;
    }
}