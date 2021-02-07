package arraysandstrings;
/*
There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a
character. Given two strings, write a function to check if they are one edit (or zero edits) away.
*/
public class Question5 {
    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pale", "pale"));
        System.out.println(isOneAway("pale", "pales"));
        System.out.println(isOneAway("pale", "vale"));
        System.out.println(isOneAway("pale", "ples"));

    }

    private static boolean isOneAway(String str1, String str2){
        int diff = str1.length() - str2.length();

        switch (diff){
            case 1:
                return checkInsertion(str1, str2);
            case 0:
                return checkReplace(str1, str2);
            case -1:
                return checkInsertion(str2, str1);
            default:
                return false;
        }



    }

    private static boolean checkReplace(String str1, String str2) {
        boolean isFound = false;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(isFound) return false;
                else isFound = true;
            }
        }

        return true;
    }

    private static boolean checkInsertion(String str1, String str2) {
        boolean isFound = false;
        int j=0;
        for(int i=0; i<str2.length(); i++, j++){
            if(str1.charAt(j) != str2.charAt(i)){
                if(isFound) return false;
                else{
                    isFound = true;
                    i--;
                }
            }
        }

        return true;
    }
}
