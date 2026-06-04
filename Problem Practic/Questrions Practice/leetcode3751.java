class Solution {
    public int totalWaviness(int num1, int num2) {
        // int diff = num2-num1;
        int count = 0;
         for(int i=num1; i<= num2; i++){
            count += getcount(i);
         }
         return count;
    }
    public int getcount(int num){
        String str = String.valueOf(num);
        int n = str.length();
        int count = 0;
        for(int i=1; i<n-1; i++){
            if(str.charAt(i-1) < str.charAt(i) && str.charAt(i) > str.charAt(i+1)
            || str.charAt(i-1) > str.charAt(i) && str.charAt(i) < str.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
