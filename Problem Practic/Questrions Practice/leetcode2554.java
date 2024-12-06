class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : banned){
            set.add(num);
        }
        for(int i=1; i<=n; i++){
            if(set.contains(i)){
                continue;
            }
            if(sum+i > maxSum){
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
