public class Solution {
    public boolean canChange(String start, String target) {
        // Remove all '_' characters to compare the order of 'L' and 'R' pieces
        String startNoBlanks = start.replace("_", "");
        String targetNoBlanks = target.replace("_", "");
        
        // If the sequences of 'L' and 'R' do not match, return false
        if (!startNoBlanks.equals(targetNoBlanks)) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;
        
        // Traverse both strings to check the relative positions of 'L' and 'R'
        while (i < n && j < n) {
            // Move i to the next non-blank character in start
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            // Move j to the next non-blank character in target
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            
            // If either pointer reaches the end, break the loop
            if (i == n || j == n) {
                break;
            }
            
            // If the current characters do not match, return false
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            
            // Check the movement rules:
            // 1. 'L' can only move to the left (i >= j)
            // 2. 'R' can only move to the right (i <= j)
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            
            // Move to the next characters
            i++;
            j++;
        }
        
        return true;
    }
}
