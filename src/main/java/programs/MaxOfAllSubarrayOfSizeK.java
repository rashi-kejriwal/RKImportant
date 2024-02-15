package programs;

import java.util.LinkedList;

public class MaxOfAllSubarrayOfSizeK {

    //https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

//    Input :
//    arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
//    k = 3
//    Output :
//    3 3 4 5 5 5 6

// Method to find the maximum for each and every contiguous subarray of size k.
    static void printKMax(int arr[], int n, int k){

        int max=0;

        for(int i=0;i<=n-k;i++){
            max=arr[0];
            for(int j=i;j<i+k;j++){
                if(arr[j]>max)
                    max=arr[j];
            }
            System.out.print(max+" ");
        }

    }
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printMax(arr, arr.length, k);
    }


    static void printMax(int arr[],int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        LinkedList<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.get(Qi.size()-1)])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.get(Qi.size()-1)])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
