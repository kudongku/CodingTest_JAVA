import java.util.ArrayList;                                                
                                                                           
class Solution {                                                           
    public int solution(int n) {                                           
        ArrayList<Integer> fibonacciArr = new ArrayList<>();               
        fibonacciArr.add(0);                                               
        fibonacciArr.add(1);                                               
        int index = 1;                                                     
                                                                           
        while (index < n) {                                                
                                                                           
            for(int i: fibonacciArr){                                      
                                                                           
                if(i>1234567){                                             
                    i%=1234567;                                            
                }                                                          
                                                                           
            }                                                              
                                                                           
            int temp = (fibonacciArr.get(0) + fibonacciArr.get(1))%1234567;                        
                                                                           
            fibonacciArr.add(temp);                                        
                                                                           
            fibonacciArr.remove(0);                                        
                                                                           
            index++;                                                       
        }                                                                  
                                                                           
        return fibonacciArr.get(1);                                        
    }                                                                      
}                                                                                                                                          