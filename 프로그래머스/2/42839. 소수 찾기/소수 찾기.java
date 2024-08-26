import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        generatePermutations("", numbers, uniqueNumbers);

        char[] arr = numbers.toCharArray();

        int primeCount = 0;
        for (int number : uniqueNumbers) {
            if (isPrime(number)) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }

        }

        return true;
    }


    private void generatePermutations(String prefix, String str, Set<Integer> set) {
        int n = str.length();

        if (!prefix.isEmpty()) {
            set.add(Integer.valueOf(prefix));
        }

        for (int i = 0; i < n; i++) {
            generatePermutations(prefix + str.charAt(i),
                str.substring(0, i) + str.substring(i + 1, n), set);
        }

    }


}