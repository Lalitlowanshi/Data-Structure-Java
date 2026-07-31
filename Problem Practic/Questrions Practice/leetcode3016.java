class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int index = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            ans += freq[i] * (index / 8 + 1);
            index++;
        }

        return ans;
    }
}
