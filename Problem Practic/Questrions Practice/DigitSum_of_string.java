public class DigitSum_of_string {
    public static void main(String[] args) {
        String s = "a1b2c3d4";
        int n = s.length();
        char [] ch = s.toCharArray();
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!Character.isLetter(ch[i])){
                ans += ch[i]-'0';
            }
        }
        System.out.println(ans);
    }
}
