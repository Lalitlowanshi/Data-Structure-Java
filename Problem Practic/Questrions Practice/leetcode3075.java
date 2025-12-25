import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness); // ascending
        
        long sum = 0;
        int decrease = 0;
        
        for (int i = happiness.length - 1; i >= 0 && k > 0; i--) {
            int value = happiness[i] - decrease;
            if (value > 0) {
                sum += value;
            }
            decrease++;
            k--;
        }
        
        return sum;
    }
}
