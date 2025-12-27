class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Keep repeating until length >= b.length
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check once length is enough
        if (sb.indexOf(b) != -1) {
            return count;
        }

        // One extra repeat (important edge case)
        sb.append(a);
        count++;

        if (sb.indexOf(b) != -1) {
            return count;
        }

        return -1;
    }
}
