package Recursion;

public class PrintArray {
    public static void printInc(int arr[], int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println(arr[index] + " ");
        printInc(arr, index + 1);


    }

    public static void main(String[] args){
        int arr[]={1,5,6,8,98,56,87,45};
        printInc(arr,0);


    }
}
