package Arrays.Logical_Problems;

public class PrimeNumber {
    public static boolean isPrime(int num){
        if(num <=0){
            return false;
        }
        for(int i=2;i<num;i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int[] arr){
        System.out.println("Prime numbers are:");

        for(int i=0;i<arr.length;i++){
            if(isPrime(arr[i])){
                System.out.println(arr[i] +" ");
            }
        }
    }
}
