import java.util.Arrays;

public class Search_in_string {
    public static void main(String[] args) {
        String name = "Kunal";
        char target = 'l';
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(Linear_search(name,target));
        System.out.println(Linear_search2(name,target));

    }
    public static boolean Linear_search(String str , char target)  {
        if (str.length()==0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target==str.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Linear_search2(String str , char target)  {
        if (str.length()==0) {
            return false;
        }
        // inhanced for loop
        for(char ch : str.toCharArray()){
            if (ch== target) {
            return true;
            }
        }
        return false;
    }
}
