class Solution {
    public String compressedString(String word) {
        String words = "";
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(count > 8){
                words += count;
                words += word.charAt(i);
                count = 0;
            }
            if(i < word.length() - 1 && word.charAt(i) == word.charAt(i+1)){
                count ++;
            }
            else{
                count++;
                words += count;
                words += word.charAt(i);
                count = 0;
            }
        }
        return words;
    }
}
