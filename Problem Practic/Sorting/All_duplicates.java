import java.util.ArrayList;
import java.util.List;

public class All_duplicates {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        // System.out.println(findDuplicates(nums));
    }
    class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap (nums, i, correct);
            }
            else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int index= 0; index< nums.length; index++){
            if(nums[index] != index + 1){
                ans.add(nums[index]);
            }
        }
        return ans;
    }
    public static void swap(int [] nums, int first, int second){
        int temp = nums [first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
}
