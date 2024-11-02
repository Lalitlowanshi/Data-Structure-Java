class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words based on spaces
        String[] words = sentence.split(" ");
        
        // Check each word with the next word in the array
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            String nextWord = words[(i + 1) % words.length];
            
            // Get the last character of the current word
            char lastChar = currentWord.charAt(currentWord.length() - 1);
            // Get the first character of the next word
            char firstChar = nextWord.charAt(0);
            
            // Check if they match
            if (lastChar != firstChar) {
                return false;
            }
        }
        
        // If all checks pass, the sentence is circular
        return true;
    }
}
