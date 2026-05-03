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
