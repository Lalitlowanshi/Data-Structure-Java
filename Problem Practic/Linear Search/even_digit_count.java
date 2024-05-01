public class even_digit_count {
    // Leetcode Qustion
    public static void main(String[] args) {
        int [] arr ={12,345,2,6,7896};
        int ans = Find_Numbers(arr);
        System.out.println(ans);

        int digits_print = No_of_digits(-4562);
        System.out.println(digits_print);
        int digits_print2 = No_of_digits2(24);
        System.out.println(digits_print2);
    }
    public static int Find_Numbers(int []arr) {
        int count = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     if (even(arr[i])) {
        //         count ++;
        //     }
        // }
        for (int i : arr) {
            if (even(i)){
                count ++;
            }
        }
        return count;   
    }
    public static boolean even (int num) {
        int Digits = No_of_digits(num);
        if (Digits % 2 == 0) {
            return true;
        }
        return false;
        // return NoOfDigits % 2 ==0;
    }
   

    public static int No_of_digits(int num) {
        if (num < 0) {
            num = num * -1;
        }
        if (num == 0) {
            return 1;
        }

        int count = 0;

        while (num>0) {
            count++;
            num = num/10;
        }
        return count;
    }

    // Optimized way to count the digits.....
    public static int No_of_digits2(int num) {
        if (num < 0) {
            num = num * -1;
        }
        if (num == 0) {
            return 1;
        }

        return (int) (Math.log10(num)) + 1;
    }
}
