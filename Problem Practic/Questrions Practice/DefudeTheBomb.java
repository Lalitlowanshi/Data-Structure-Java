https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18
class Solution {
    public int[] decrypt(int[] code, int k) {
        int count = 0;
        int sum = 0;
        int [] arr = new int[code.length];
        if(k == 0){
            return arr;
        }
        int index = 0;
        if(k > 0){
            for(int i=0; i<code.length; i++){
                int j = i+1;
                while(count < k){
                    if(j == code.length){
                        j = 0;
                    }
                    sum += code[j];
                    count++;
                    j++;
                }
                arr[index++] = sum;
                sum = 0;
                count = 0;
            }
        }

        sum = 0;
        count = 0;

        if(k < 0){
            for(int i=0; i<code.length; i++){
                int j = i-1;
                while(count > k){
                    if(j == -1){
                        j = code.length-1;
                    }
                    sum += code[j];
                    count--;
                    j--;
                }
                arr[index++] = sum;
                sum = 0;
                count = 0;
            }
        }

        return arr;
    }
}
