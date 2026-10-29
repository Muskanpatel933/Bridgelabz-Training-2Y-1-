package Recursion;

public class SumOfArray {
    public static int sum(int[]arr,int index){
        if(index== arr.length){
            return 0;
        }
        int add=sum(arr,index+1);
        return add+arr[index];

    }
    public static void main(String[] args){
        int arr[]={12,34,5,23};
        System.out.println(sum(arr,0));
    }
}
