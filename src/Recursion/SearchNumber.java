package Recursion;

public class SearchNumber {
    public static int search(int arr[],int index,int target){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return search(arr,index+1,target);

    }
    public static void main(String[] args){
        int arr[]={1,34,5,56,798,23};
        System.out.println(search(arr,0,56));
    }
}
