package programs;

import java.util.HashMap;

public class getPairCount {
//    Examples:
//    Input  :  arr[] = {1, 5, 7, -1},
//    sum = 6
//    Output :  2
//    Pairs with sum 6 are (1, 5) and (7, -1)
     static int arr[] = new int[]{1, 5, 7, -1, 5} ;

    static int getPairsCount(int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        // Store counts of all elements in map hm
        for (int i=0; i<n; i++){

            // initializing value to 0, if key not found
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],1);
            else
                hm.put(arr[i], hm.get(arr[i])+1);
        }

        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(hm.get(sum-arr[i]) != null)
                twice_count += hm.get(sum-arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count/2;
    }
}
