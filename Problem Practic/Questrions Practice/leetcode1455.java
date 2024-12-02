class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int count = 0;
        for(int i=0; i<words.length; i++){
            if(words[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}
