class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            // Append the current character to the result
            result.append(s.charAt(i));
            
            // Check if the last three characters are the same
            if (result.length() >= 3 && 
                result.charAt(result.length() - 1) == result.charAt(result.length() - 2) &&
                result.charAt(result.length() - 2) == result.charAt(result.length() - 3)) {
                // Remove the last added character (the third consecutive one)
                result.deleteCharAt(result.length() - 1);
            }
        }
        
        return result.toString();
    }
}
