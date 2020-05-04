import java.util.Arrays;
import java.util.Random;
import java.lang.System;

class Sorting {

    public static int[] insertionSort(int[] array) {
        int[] sorted = array;
        int i=1, temp;

        while (i<sorted.length) {
            if(i > 0 && sorted[i] < sorted[i-1]) {
                temp = sorted[i];
                sorted[i] = sorted[i-1];
                sorted[i-1] = temp;
                
                i--;                
            }
            else
                i++;
        
        }
        
        return sorted;
    }

    public static int[] selectionSort(int[] array) {
        int[] sorted = array;
        int minIndex, temp;

        for(int i=0;i<sorted.length-1;i++) {
            minIndex = i;

            for(int j=i+1;j<sorted.length;j++) {
                if(sorted[minIndex] > sorted[j])
                    minIndex = j;
            }

            temp = sorted[i];
            sorted[i] = sorted[minIndex];
            sorted[minIndex] = temp;
            
        }
        return array;
    }

    public static int[] bogoSort(int[] array) {
        while(isSorted(array) == false) {
            array = shuffle(array);
        }

        return array;
    }

    // the following are 2 helper functions for BogoSort
    private static int[] shuffle(int[] array) {
        int index;
        Random rand = new Random();

        for(int i=array.length-1;i>0;i--) {
            index = rand.nextInt(i);
            
            int temp = array[i]; 
            array[i] = array[index]; 
            array[index] = temp; 
        }

        return array;
    } 
    private static boolean isSorted(int[] array) { 
        for (int i=0;i<array.length-1;i++) { 
            if (array[i] > array[i+1]) 
                return false; 
        }
        return true; 
    } 

    public static int[] mergeSort(int[] array) {
        if(array.length<=1) return array; 
  

        int halfwayPoint = array.length/2;

        //split array
        int L[] = new int[halfwayPoint];
        
        int R[] = new int[halfwayPoint]; 

        if((array.length%2) == 1) {
            R = new int[halfwayPoint+1];
        }
  
        for (int i=0; i<L.length; i++) 
            L[i] = array[i]; 
        for (int j=0; j<R.length; j++) {
            R[j] = array[j+halfwayPoint];
        }

        L = mergeSort(L);
        R = mergeSort(R);

        
        return mergeArray(L, R);
    }

    public static int[] enhancedMergeSort(int[] array) {
        final int THRESHOLD = 50;

        if(array.length<=1) return array; 
  
        if(array.length <= THRESHOLD) {
            return insertionSort(array);
        }
        
        int halfwayPoint = array.length/2;

        //split array
        int L[] = new int[halfwayPoint];
        
        int R[] = new int[halfwayPoint]; 

        if((array.length%2) == 1) {
            R = new int[halfwayPoint+1];
        }
  
        for (int i=0; i<L.length; i++) 
            L[i] = array[i]; 
        for (int j=0; j<R.length; j++) {
            R[j] = array[j+halfwayPoint];
        }

        L = mergeSort(L);
        R = mergeSort(R);

        
        return mergeArray(L, R);
    }

    private static int[] mergeArray(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] merged = new int[n];

        for(int i=0;i<a.length;i++) {
            merged[i] = a[i];
            merged[i+a.length] = b[i];
        }
        merged[merged.length-1] = b[b.length-1];
        return merged;
    }

    private static void testSorting(int[] testArray) {
        System.out.println("\n\t\tFor Array of size " +testArray.length+ ", time in miliseconds:");
        /*
        final Long startInsertion = System.currentTimeMillis();
        insertionSort(testArray);
        final Long totalInsertion = System.currentTimeMillis() - startInsertion;
        System.out.println("Insertion sort: " +totalInsertion);

        final Long startSelection = System.currentTimeMillis();
        selectionSort(testArray);
        final Long totalSelection = System.currentTimeMillis() - startSelection;
        System.out.println("Selection sort: " +totalSelection);
        */
        final Long startMerge = System.nanoTime();
        mergeSort(testArray);
        final Long totalMerge = System.nanoTime() - startMerge;
        System.out.println("Merge sort: " +totalMerge);

        final Long startMerge2 = System.nanoTime();
        enhancedMergeSort(testArray);
        final Long totalMerge2 = System.nanoTime() - startMerge2;
        System.out.println("Enhanced merge sort: " +totalMerge2);

        final Long startQuick = System.nanoTime();
        quickSort(testArray, 0, testArray.length);
        final Long totalQuick = System.nanoTime() - startQuick;
        System.out.println("Quicksort: " +totalQuick);
   
    }

    public static int[] quickSort(int[] array, int upperLimit, int lowerLimit) {
        if(lowerLimit < upperLimit) {
            int partition = partition(array, upperLimit, lowerLimit);

            array = quickSort(array, upperLimit, partition+1);
            array = quickSort(array, partition-1, lowerLimit);
            
        }
        return array;
    }

    private static int partition(int[] array, int ul, int ll) {
        int pivot = array[ul];
        int index = ll-1;

        for(int i=ll;i<=ul;i++) {
            if(array[i] < pivot) {
                index++;
                
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

        index++;
        int temp = array[index];
        array[index] = array[ul];
        array[ul] = temp;

        return index;
    }

    public static void main(String[] args) {
        int n=700;
        int[] test = new int[n];
        Random rand = new Random();
        for(int i=0;i<n;i++) {
            test[i] = rand.nextInt(1000000);
        }

        testSorting(test);

    }
}