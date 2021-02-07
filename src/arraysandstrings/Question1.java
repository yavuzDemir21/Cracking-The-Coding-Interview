package arraysandstrings;

/*
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/

public class Question1 {

    public static void main(String[] args) {

        System.out.println(isUnique("ipek"));
        System.out.println(isUnique("ipekolmayan"));

    }
    //lower case english 'a' 'z'  58 59     'b'-'a' = 1
    private static boolean isUnique(String str){

        boolean[] abc = new boolean[128];


        for(char c : str.toCharArray()){


            if(abc[c]) return false;

            abc[c] = true;
        }

        return true;



    }

}
