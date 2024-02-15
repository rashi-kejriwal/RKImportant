package programs;

import java.util.Arrays;

public class anagrams {
    static int NO_OF_CHARS = 256;

    /* function to check whether two strings
    are anagram of each other */
    static boolean areAnagram(char str1[], char str2[])
    {
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int [NO_OF_CHARS];
       // Arrays.fill(count1, 0);
        int count2[] = new int [NO_OF_CHARS];
      //  Arrays.fill(count2, 0);
        int i;

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;


        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i <str1.length && i < str2.length ; i++)
        {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
    public static void main(String args[])
    {
        char str1[] = ("geeksforgeeks").toCharArray();
        char str2[] = ("forgeeksgeeks").toCharArray();

        if ( areAnagram(str1, str2) )
            System.out.println("The two strings are " +
                    "anagram of each other");
        else
            System.out.println("The two strings are not"+
                    " anagram of each other");
    }

    static void isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }


}
