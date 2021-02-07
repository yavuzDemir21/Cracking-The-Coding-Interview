package arraysandstrings;

/*
Write a method to replace all spaces in a string with '%20'.You may assume that the string has sufficient space at the
end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing
in Java,please use a character array so that you can perform this operation in place.)
*/

public class Question3 {
    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    ", 13));
        System.out.println(urlify("MrJohnSmith" , 11));
        System.out.println(urlify("Mr  JohnSmith    " , 13));
    }

    private static String urlify(String str, int len){
        char[] arr = str.toCharArray();

        int idx = arr.length-1;
        for(int i=len-1; i>=0; i--){
            if(arr[i] != ' '){
                arr[idx] = arr[i];
                idx--;
            }else{
                arr[idx] = '0';
                idx--;
                arr[idx] = '2';
                idx--;
                arr[idx] = '%';
                idx--;
            }
        }


        return new String(arr);
    }


}
