package Arrays.HashMap;

import java.util.HashMap;

public class Practice1 {
    static void main(String[] args) {
        HashMap<String, Integer> studentAge = new HashMap<>();
        studentAge.put("Rahul",21);
        studentAge.put("Mayank", 22);
        studentAge.put("Ayushi",20);


        System.out.println("Ayushi's age:" +studentAge.get("Ayushi"));

        studentAge.put("Ayushi",21);

        boolean hasMayank  = studentAge.containsKey("Mayank");

        studentAge.remove("Rahul");

        for(String name : studentAge.keySet()) {
            System.out.println(name + "is" + studentAge.get(name)+"year old");
        }
       for(int number : studentAge.values()){
           System.out.println(number);
       }

    }
}
