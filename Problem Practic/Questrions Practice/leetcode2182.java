import java.util.PriorityQueue;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Frequency array to count characters
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max heap to store characters in descending order of lexicographical order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add character and its frequency to the heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // Store character index and frequency
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll(); // Current largest character
            int charIndex = curr[0];
            int count = curr[1];

            int useCount = Math.min(count, repeatLimit); // How many times we can use this character
            for (int i = 0; i < useCount; i++) {
                result.append((char) (charIndex + 'a'));
            }

            // If there are remaining characters, push it back
            if (count > useCount) {
                if (maxHeap.isEmpty()) break; // No other character to break the streak

                int[] next = maxHeap.poll(); // Next largest character
                result.append((char) (next[0] + 'a')); // Use the next character once
                next[1]--;

                // Push both characters back to the heap if still remaining
                if (next[1] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(new int[]{charIndex, count - useCount});
            }
        }

        return result.toString();
    }
}
