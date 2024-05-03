public class MaxWealth {
    // Leetcode Question
    public static void main(String[] args) {
        int [] [] a = {{1,2,3,4},{2,4,5},{8,9}};
        int value = maximun_wealth(a);
        System.out.println(value);        
    }
    public static int maximun_wealth(int [][]accounts) {
        // person = rows 
        // account = cols
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts [person] [account];
            }
            if (sum > ans) {
                ans = sum ;
            }
        }
        return ans;
    }
}
