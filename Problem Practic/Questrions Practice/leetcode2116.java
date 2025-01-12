class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the string length is odd, it can't be valid
        if (s.length() % 2 != 0) return false;

        int balance = 0;
        // First pass: Check from left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                balance++;
            } else {
                balance--;
            }
            // If balance goes negative, there are more ')' than '(' available
            if (balance < 0) return false;
        }

        balance = 0;
        // Second pass: Check from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                balance++;
            } else {
                balance--;
            }
            // If balance goes negative, there are more '(' than ')' available
            if (balance < 0) return false;
        }

        // If both passes are valid, return true
        return true;
    }
}
