/*
Name: Jack Muir
Date: 12-1-2021
Program Name: SortingCompare
Description: The program sorts two identical arrays using a bubble and selection sort. In each algorithm it counts
the number of exchanges done, then displays its value.
 */
public class SortingCompare {

    //Driver Function
    public static void main (String[] args)
    {
        //Identical Arrays
        int[] bubbleArray = {0, 5, 6, 7, 3, 44, 40, 3, 134, 5, 39, 2, 3,32, 45, 12, 5, 6,42 , 78};
        int[] selectionArray = {0, 5, 6, 7, 3, 44, 40, 3, 134, 5, 39, 2, 3,32, 45, 12, 5, 6,42 , 78};

        System.out.print("Array used: ");
        printArray(bubbleArray);
        System.out.println("Bubble Sort: " + bubbleSort(bubbleArray) + " exchanges");
        printArray(bubbleArray);
        System.out.println("Selection Sort: " + selectionSort(selectionArray) + " exchanges");
        printArray(selectionArray);
    }

    //Bubble sort algorithm
    static int bubbleSort(int arr[])
    {
        int exchanges = 0; //counter
        int n = arr.length;

        //loop through each combination of elements for swapping
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    exchanges++;//increase counter after swap
                }
        return exchanges;
    }

    //selection sort algorithm
    static int selectionSort(int arr[])
    {
        int exchanges = 0;//counter
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            exchanges++; //increase counter after swap
        }
        return exchanges;
    }

    /* Prints the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
