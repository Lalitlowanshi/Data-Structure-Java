import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Compute prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Deque to store indices of the prefix sum array
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            // Check if the subarray sum meets the condition
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            
            // Maintain monotonicity of the deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.addLast(i);
        }
        
        // Return the result
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
