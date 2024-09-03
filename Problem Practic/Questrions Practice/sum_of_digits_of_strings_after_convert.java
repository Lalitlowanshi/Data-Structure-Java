public class sum_of_digits_of_strings_after_convert {
    public static int getLucky(String s, int k) {

        StringBuilder sum = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) { 
            int var = ((int) s.charAt(i) - 96);
            sum.append(var);  
        }
        
        int result = 0;

        while (k > 0) {
            result = 0;  

            for (int i = 0; i < sum.length(); i++) {
                result += sum.charAt(i) - '0';  // Convert character to integer correctly
            }

            sum = new StringBuilder(String.valueOf(result));
            k--; 
        }
        
        return result;  
    }
}
