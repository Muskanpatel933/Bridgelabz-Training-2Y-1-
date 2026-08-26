package Arrays.Logical_Problems;

public class RemoveDuplicate {
    public static void display(int arr[]){
        for(int i =0;i<arr.length;i++){
            if(arr[i]!=1){
                System.out.println(arr[i] + " ");
            }
        }
    }
    public static void removeDuplicate(int arr[]){
        System.out.println("Initial array: ");
        display(arr);
        for (int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]  == arr[j]){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
    }
}
