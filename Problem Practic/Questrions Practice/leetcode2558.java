import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max heap to efficiently get the largest element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                int max = maxHeap.poll(); // Get the largest element
                maxHeap.add((int) Math.sqrt(max)); // Add its square root back
            }
        }

        // Sum the remaining elements in the heap
        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
