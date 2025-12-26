class Solution {
    public String reverseWords(String s) {

        // remove extra spaces from start & end
        s = s.trim();

        // split by one or more spaces
        String[] words = s.split("\\s+");

        // reverse words
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
