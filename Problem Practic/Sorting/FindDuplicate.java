public class FindDuplicate {
    public static void main(String[] args) {
        int [] arr= {1,3,4,2,2};
        System.out.println(Find_duplicate(arr));
    }
    public static int Find_duplicate(int [] nums){
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums,i, correct);
            }
            else{
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index+1) {
                return nums[index];
            }
        }
        return -1;
    }
    public static void swap(int [] a ,int first ,  int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}