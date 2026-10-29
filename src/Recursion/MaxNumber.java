package Recursion;

public class MaxNumber {
    public static int max(int[] arr,int index){
        if(index==arr.length){
            return Integer.MAX_VALUE;
        }
        int small=max(arr,index+1);
        return  Math.max(arr[index],small);

    }
    public static void main(String[] args){
        int arr[]= {2,46,45,67,22};

        System.out.println(max(arr,0));
    }
}

