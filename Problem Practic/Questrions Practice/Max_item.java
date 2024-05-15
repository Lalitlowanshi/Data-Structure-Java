public class Max_item {
    public static void main(String[] args) {

        int [] arr = {1,3,9,23,18};
        System.out.println(max(arr));
        System.out.println(max_range(arr, 1, 2));
    }
    @SuppressWarnings("unused")
    public static int max(int [] arr ) {

        if(arr.length==0){
            return-1;
        }
        
        if(arr==null){
            return -1;
        }

        int maxvalue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxvalue){
                maxvalue=arr[i];
            }
        }
        return maxvalue;
    }
    public static int max_range(int [] arr , int start, int end) {
  
        if(end<start){
            return -1;
        }

        if (start==end){
            return arr[start];
        }

        if(arr==null){
            return -1;
        }

        if(arr.length==0){
            return-1;
        }

        int maxvalue = arr[0];
         for (int i = start; i <= end; i++) {
             if(arr[i]>maxvalue){
                maxvalue=arr[i];
            }
        }
        return maxvalue;
    }
}
