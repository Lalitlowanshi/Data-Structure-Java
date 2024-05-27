package String;

public class pelindrome {
    public static void main(String[] args) {
        String  str = null;
        System.out.println(is_pelin(str));
    }
    // Pelindome = Number is same as reading from "start to end" and from "end to start"
    // like abcdcba, aba, abcdefedcba etc....
    public static boolean is_pelin(String str) {
        if ( str == null || str.length() == 0 ) {
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-1-i);
            if (start != end) {
               return false; 
            }   
        }
        return true;
    }
}
