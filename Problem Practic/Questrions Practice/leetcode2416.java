package Leetcode;

/**
 * leetcode2416
 */
public class leetcode2416 {

    public static void main(String[] args) {
        
    }
    public static int[] sumPrefixScores1(String[] words) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String str = "";
            for (int l = 0; l < words[i].length(); l++) {
                str += words[i].charAt(l);
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    int freq = map.get(str);
                    map.put(str, freq + 1);
                }
            }
        }
        int[] res = new int[words.length];
        String str = "";
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                str += words[i].charAt(j);
                count += map.get(str);
            }
            res[i] = count;
            str = "";
        }
        return res;
    }
}