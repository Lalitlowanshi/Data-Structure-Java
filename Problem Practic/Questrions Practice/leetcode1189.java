class Solution {
    public int maxNumberOfBalloons(String text) {
        // B A LL OO N
        // int n = text.length();
        int [] arr = new int[5];
        for(char c : text.toCharArray()){
            if(c == 'b'){
                arr[0]++;
            }
            else if(c == 'a'){
                arr[1]++;
            }
            else if(c == 'l'){
                arr[2]++;
            }
            else if(c == 'o'){
                arr[3]++;
            }
            else if(c == 'n'){
                arr[4]++;
            }
        }
        int min = Integer.MAX_VALUE;
        arr[2] /= 2;
        arr[3] /= 2;
        for(int i=0; i<5; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}




// CHATGPT Solution.....
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        // Count frequency
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        // Calculate possible "balloon"
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a'] / 2;
        int o = freq['o' - 'a'] / 2;
        int n = freq['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}
