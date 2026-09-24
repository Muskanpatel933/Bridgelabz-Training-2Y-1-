package Arrays.Logical_Problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LearningArray {
    public static void main(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2,4);
        list.add(1,4);
        list.add(5,3);
        list.add(0,4);
        list.add(2,5);
        list.add(7,9);
        System.out.println("This is out ArrayList :-");
        System.out.println(list);

        int result[] = new int[26];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        System.out.println("This is an Array:- ");
        System.out.println(Arrays.toString(result));

    }
}
