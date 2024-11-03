class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false; // If lengths differ, they can't match by rotation
        }
        
        // Concatenate s with itself to check all possible rotations
        String doubled = s + s;
        
        // Check if goal is a substring of the doubled string
        return doubled.contains(goal);
    }
}
/*
class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are different, they can't match by any rotation
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Early check: if s already equals goal, return true
        if (s.equals(goal)) {
            return true;
        }
        
        // Rotate s left by one character at a time
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // Move first character to the end of the string
            s = s.substring(1) + s.charAt(0);
            
            // Check if this rotation matches the goal
            if (s.equals(goal)) {
                return true;
            }
        }
        
        return false;
    }
}
*/
