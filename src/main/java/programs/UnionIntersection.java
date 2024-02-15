package programs;

import java.util.HashSet;

public class UnionIntersection {
    // Prints union of arr1[0..m-1] and arr2[0..n-1]
    static void printUnion(int arr1[], int arr2[])
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < arr1.length; i++)
            hs.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            hs.add(arr2[i]);
        System.out.println(hs);
    }

    // Prints intersection of arr1[0..m-1] and arr2[0..n-1]
    static void printIntersection(int arr1[], int arr2[])
    {
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < arr1.length; i++)
            hs.add(arr1[i]);

        for (int i = 0; i < arr2.length; i++)
            if (hs.contains(arr2[i]))
                System.out.print(arr2[i] + " ");
    }
}
