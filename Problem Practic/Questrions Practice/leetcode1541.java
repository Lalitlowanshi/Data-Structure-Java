class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (need % 2 == 1) {
                    count++;
                    need--;
                }

                need += 2;
            } else {
                need--;

                if (need < 0) {
                    count++;
                    need = 1;
                }
            }
        }

        return count + need;
    }
}
