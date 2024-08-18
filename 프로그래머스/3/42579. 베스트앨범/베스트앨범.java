import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> genreIndex = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            map.putIfAbsent(genres[i],0);
            map.put(genres[i], map.get(genres[i]) + plays[i]);
            genreIndex.putIfAbsent(genres[i],new ArrayList<>());
            genreIndex.get(genres[i]).add(i);
        }

        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort(Comparator.comparingInt(map::get).reversed());
        List<Integer> answer = new ArrayList<>();

        for(String str : genreList){
            List<Integer> indexes = genreIndex.get(str);
            indexes.sort(Comparator.comparingInt(
                (i) -> plays[(int) i]
            ).reversed());

            System.out.println("indexes = " + indexes);

            for(int i =0; i<Math.min(2, indexes.size()); i++){
                answer.add(indexes.get(i));
            }
        }


        return answer;
    }
}