package programs;
import java.util.*;


class GFG {

    // The main function that prints the
    // arrangement with the largest value.
    // The function accepts a vector of strings
    static void printLargest(List<String> arr){

        Collections.sort(arr, new Comparator<String>(){

            // A comparison function which is used by
            // sort() in printLargest()
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY=X + Y;

                // then append X at the end of Y
                String YX=Y + X;

                // Now see which of the two formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1:1;
            }
        });

        Iterator it = arr.iterator();

        while(it.hasNext())
            System.out.print(it.next());

    }

    // driver program
    public static void main (String[] args) {

        List<String> arr=new ArrayList<String>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);

        // output should be 777776
        /* arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");
        */

        //output should be 998764543431
        /*arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        */
    }
}