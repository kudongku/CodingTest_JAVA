import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];

        for(int i=1; i<students.length; i++){

            for(int j : lost){

                if(i==j){
                    students[i]--;
                }

            }

            for(int k : reserve){

                if(i==k){
                    students[i]++;
                }

            }

        }

        for(int i=1; i<students.length; i++){

            if(i!=1 && students[i]>0 && students[i-1]<0){
                students[i]--;
                students[i-1]++;
            }

            if(i!=n && students[i]>0 && students[i+1]<0){
                students[i]--;
                students[i+1]++;
            }

        }

        int answer = 0;

        for(int i=1; i<students.length; i++){

            if(students[i]>=0){
                answer++;
            }

        }

        System.out.println(Arrays.toString(students));

        return answer;
    }
}