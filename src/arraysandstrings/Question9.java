package arraysandstrings;

/*
Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, sl and s2,
write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation
of"erbottlewat").
*/

public class Question9 {
    public static void main(String[] args) {
        System.out.println(stringRotation("waterbottle", "erbottlewat"));
    }

    private static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    private static boolean stringRotation(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        String merged = s1 + s1;

        return isSubstring(merged, s2);
    }



}
