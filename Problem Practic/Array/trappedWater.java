package Questions;
public class trappedWater {
    public static void trapped(int[]arr){
        int n=arr.length;
        int lm[]=new int[n];
        lm[0]=arr[0];
        int lmax=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            lmax=Math.max(lmax, arr[i]);
            lm[i]=lmax;
            // System.out.print(lm[i] +" ");
        }
        int rm[]=new int[n];
        rm[n-1]=arr[n-1];
        int rmax=Integer.MIN_VALUE;
        for (int i = n-1; i >=0; i--) {
            rmax=Math.max(rmax, arr[i]);
        rm[i]=rmax;
        // System.out.print(rm[i]);
        }
        int max=0;
        for (int i = 0; i < rm.length; i++) {
            max=max+Math.min(lm[i], rm[i])-arr[i];
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int arr[]={4,2,0,6,3,2,5};
        trapped(arr);
    }
}
