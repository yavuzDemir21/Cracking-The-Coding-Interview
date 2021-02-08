package arraysandstrings;
/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string
aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your
method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class Question6 {
    public static void main(String[] args) {

        System.out.println(stringCompression("aabcccccaaa"));
        System.out.println(stringCompression("abc"));

    }

    private static String stringCompression(String str){
        if(str.length() <= 2) return str;

        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char cur = arr[0];
        int count = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i] == cur){
                count++;
            }else{
                sb.append(cur);
                sb.append(count);
                cur = arr[i];
                count = 1;
            }
        }
        sb.append(cur);
        sb.append(count);

        return sb.length() >= str.length() ? str : sb.toString();
    }

}
