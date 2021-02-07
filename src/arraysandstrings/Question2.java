package arraysandstrings;

public class Question2 {
    public static void main(String[] args) {

        System.out.println(checkPermutation("aba", "baa"));
        System.out.println(checkPermutation("abac", "baab"));
    }
    private static boolean checkPermutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        int[] abc = new int[128];

        for(char c : str1.toCharArray()){
            abc[c]++;
        }

        for(char c : str2.toCharArray()){
            if(abc[c] == 0) return false;
            abc[c]--;
        }

        return true;
    }
}
