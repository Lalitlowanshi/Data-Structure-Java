//Insertion sort..........
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i=1; i<n; i++){
            int curr = nums[i];
            int j = i-1;

            while(j >= 0 && nums[j] > curr){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = curr;
        }
        return nums;
    }
}





//Selection sort...........
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int min = 0;

        for(int i=0; i<n-1; i++){
            min = i;
            for(int j=i+1; j<n; j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        } 
        return nums;
    }
}





// Bubble Sort............
class Solution {
    public int[] sortArray(int[] nums) {
        //Bubble Sort 
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}





// Merge sort............
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        // size = current subarray size
        for (int size = 1; size < n; size *= 2) {

            // left = starting index of subarray
            for (int left = 0; left < n - size; left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                merge(nums, temp, left, mid, right);
            }
        }
        return nums;
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;     // left subarray pointer
        int j = mid + 1;  // right subarray pointer
        int k = left;     // temp array pointer

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // copy back to original array
        for (int x = left; x <= right; x++) {
            nums[x] = temp[x];
        }
    }
}

