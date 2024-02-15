package programs;

import java.util.HashMap;

public class FirstNonReapeatingchar {
    //https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/

    // Java program to find first non-repeating character
// Note : hashmap is used

    class CountIndex
    {
        int count,index;

        // constructor for first occurrence
        public CountIndex(int index) {
            this.count = 1;
            this.index = index;
        }

        // method for updating count
        public void incCount() {
            this.count++;
            hashCode();
        }
    }




    class GFG
    {
        static final int NO_OF_CHARS = 256;

        HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);

        /* calculate count of characters
           in the passed string */
        void getCharCountArray(String str)
        {
            for (int i = 0; i < str.length();  i++)
            {
                // If character already occurred,
                if(hm.containsKey(str.charAt(i)))
                {
                    // updating count
                    hm.get(str.charAt(i)).incCount();
                }

                // If it's first occurrence, then store the index and count = 1
                else
                {
                    hm.put(str.charAt(i), new CountIndex(i));
                }

            }
        }

        /* The method returns index of first non-repeating
           character in a string. If all characters are repeating
           then returns -1 */
        int firstNonRepeating(String str)
        {
            getCharCountArray(str);
            int result = Integer.MAX_VALUE, i;

            for (i = 0; i < str.length();  i++)
            {
                // If this character occurs only once and appears
                // before the current result, then update the result
                if (hm.get(str.charAt(i)).count == 1 && result > hm.get(str.charAt(i)).index){
                    result = hm.get(str.charAt(i)).index;
                }

            }

            return result;
        }

        // Driver method
        public void main (String[] args)
        {
            String str = "geeksforgeeks";
            int index =  firstNonRepeating(str);

            System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " +
                    " or string is empty" : "First non-repeating character is " +  str.charAt(index));
        }
    }
}
