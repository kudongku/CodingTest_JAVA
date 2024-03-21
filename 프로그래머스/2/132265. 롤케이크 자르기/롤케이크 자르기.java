import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> toppings = new HashMap<>(); // key : topping 종류, value : topping 개수
        Stack<Integer> chulsoo = new Stack<>();
        Set<Integer> brother = new HashSet<>();

        for (int i : topping) {

            if (toppings.containsKey(i)) {
                int temp = toppings.get(i);
                toppings.put(i, ++temp);
            } else {
                toppings.put(i, 1);
            }

            chulsoo.push(i);
        }

        int halfToppingsLength = toppings.size()/2;

        for(int i=0; i<topping.length; i++){
            int bro = chulsoo.pop();
            int brosCount = toppings.get(bro);

            if(brosCount==1){
                toppings.remove(bro);
            }else{
                toppings.put(bro, --brosCount);
            }

            if(!brother.contains(bro)){
                brother.add(bro);
            }

            if(brother.size() == toppings.size()){
                answer++;
            }
            
            if(brother.size() > toppings.size()){
                break;
            }

        }

        return answer;
    }
}