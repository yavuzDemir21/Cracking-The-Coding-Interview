package arraysandstrings;
/*
Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase
that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to
be limited to just dictionary words.
*/
public class Question4 {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
    private static boolean isPalindromePermutation(String str){
        str = str.toLowerCase();

        boolean[] arr = new boolean[128];
        int oddCount = 0;

        for(char c : str.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                oddCount = arr[c] ? oddCount-1 : oddCount+1;
                arr[c] = !arr[c];
            }
        }

        return oddCount <= 1;

    }
}
