import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Iterate through each word in the array
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip the same word comparison
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Break the inner loop as we found a match
                }
            }
        }
        return result;
    }
