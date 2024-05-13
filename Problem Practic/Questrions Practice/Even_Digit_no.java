public class Even_Digit_no {
   
        public static void even(int [] n){
            // int cs= 0;
            // int ms=Integer.MIN_VALUE;
            int index=0;
            for( int i=0; i<n.length; i++){
                int count=0;
                while(n[i]/10 !=0 || n[i]%10 !=0){
                    n[i] = n[i]/10;
                    count++;
                }
                    if(count%2 ==0){
                        index++;
                    }
                
            }
            System.out.println(index+" even digit number");
        }
        
        public static void main(String[] args) {
            int [] n = {2,222,112335,12315};
            even(n);
        }
    }
