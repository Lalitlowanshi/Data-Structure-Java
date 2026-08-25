class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int x = k;

        while (set.contains(x)) {
            x += k;
        }

        return x;
    }
}
