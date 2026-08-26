class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            // We only care about windows containing exactly k ones
            if (ones > k) {
                while (left <= right && s.charAt(left) != '1') {
                    left++;
                }

                left++; // remove the first '1'
                ones--;
            }

            if (ones == k) {
                // Remove leading zeros to make the substring shortest
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }

                String candidate = s.substring(left, right + 1);

                if (ans.isEmpty()
                        || candidate.length() < ans.length()
                        || (candidate.length() == ans.length()
                            && candidate.compareTo(ans) < 0)) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }
}
