class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int [] first = new int[26];
        int [] last = new int[26];

        Arrays.fill(first, -1);

        for(int i=0; i<n; i++){
            int ch = s.charAt(i) - 'a';

            if(first[ch] == -1){
                first[ch] = i;
            }
            last[ch] = i;
        }
        List<int[]> intervals = new ArrayList<>();

        for(int c=0; c<26; c++){
            if(first[c] == -1){
                continue;
            }
            int l = first[c];
            int r = last[c];

            boolean valid = true;

            for(int i=l; i<=r; i++){
                int ch = s.charAt(i) - 'a';

                if(first[ch] < l){
                    valid = false;
                    break;
                }
                 r = Math.max(r, last[ch]);
            }
            if(valid){
                intervals.add(new int[]{l,r});
            }
        }
        intervals.sort((a,b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for(int [] interval : intervals){
            int l = interval[0];
            int r = interval[1];

            if(l > prevEnd){
                ans.add(s.substring(l,r+1));
                prevEnd = r;
            }
        }
        return ans;
    }
}
