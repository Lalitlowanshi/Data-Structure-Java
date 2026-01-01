class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(Character.toLowerCase(c)) &&
                set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // split here
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }

        return s; // whole string is nice
    }
}
