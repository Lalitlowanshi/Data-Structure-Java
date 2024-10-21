public class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> uniqueSubstrings) {
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);

            if (!uniqueSubstrings.contains(substring)) {
                uniqueSubstrings.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, i, uniqueSubstrings));
                uniqueSubstrings.remove(substring);
            }
        }

        return maxSplits;
    }
}
