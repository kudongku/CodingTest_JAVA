import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int counter = 0;
        ArrayList<Integer> sums = new ArrayList();

        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                        sums.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        System.out.println(sums);

        for(int num : sums){
            int count = 0;
            for(int i=2; i<num; i++){
                if(num%i==0){
                    count++;
                }
            }
            if(count==0){
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }
}