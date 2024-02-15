package programs;

public class ArrayRotation {
//    Let us take the same example arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
//    Rotate arr[] by one 2 times
//    We get [2, 3, 4, 5, 6, 7, 1] after first rotation and [ 3, 4, 5, 6, 7, 1, 2] after second rotation.

    int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    /*Function to left rotate arr[] of siz n by d*/
    void leftRotate(int arr[], int d, int n)
    {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++)
        {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (1 != 0)
            {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*UTILITY FUNCTIONS*/

    /* function to print an array */
    void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

}
