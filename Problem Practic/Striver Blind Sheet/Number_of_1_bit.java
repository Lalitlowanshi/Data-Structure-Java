class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        String Binary = Integer.toBinaryString(n);
        for(int i=0; i<Binary.length(); i++){
            if(Binary.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
