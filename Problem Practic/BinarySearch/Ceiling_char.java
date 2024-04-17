public class Ceiling_char {
    // it is exactly same as the ceiling code but the difference is only the equal value does not to be return
    // and one ,ore diference is "the letter wrap around" i.e. the last letter or greater have to return the first value
    // In this code we are just returning the value not index element....

public static void main(String[] args) {
    char [] a = {'a','c','d','j'};
    char target = 'b';
    char ans = search (a , target);
    // print smallet greater or equal value of target element 
    System.out.println(ans);
}

public static char search(char [] a ,char target){
    int start = 0;
    int end = a.length -1;

   while (start <= end ) {
        // finding mid element
        int mid = start + (end - start)/2;
        // target present left side to the mid element
        if (a[mid] > target) {
            end = mid -1 ;
        }
        // target present right side to the mid element 
        else {
            start = mid +1;
        }
    }
    // return a smallest greater value of target
    return a[start % a.length] ;
    // this value is only return for "the wrap around condition" i.e. the greater or equal to the last element can return the first element 
}
}
