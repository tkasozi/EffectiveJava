/**
 * This file contains/demonstrates some of the most common sorting algorithms
 * created March 30, 2016
 * <talik.aziizi@gmail.com>
 */
package sortingalgorithms;

/**
 *
 * @author tkasozi
 */
public class SortingAlgorithms {

    protected static void swap(int[] A, int i, int j) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }

    public static double permutation(int i) {
        switch (i) {
            case 0:
                return 1;
            default:
                return i * permutation(--i);
        }
    }

    //From Left to Right move each element to
    //it's right place.
    public static int[] bubbleSort(int[] A) {

        for (int x = 0; x < A.length; x++) {

            for (int i = x; i < A.length; i++) {

                if (A[x] > A[i]) {
                    swap(A, x, i);
                }
            }
        }

        return A;
    }

    //keep record of the smallest element
    //move the smallest element to the left.
    public static int[] selectSort(int[] A) {
        int smallest;

        for (int x = 0; x < A.length; x++) {
            smallest = A[x];
            for (int i = x; i < A.length; i++) {

                if (A[i] < smallest) {
                    //swapp right away.
                    smallest = A[i];//?
                    swap(A, i, x);
                }
            }
        }
        return A;
    }

    /**
     * pick one element, compare that element with every element on the left
     *
     * int[] A = {1, 50, 35, 45, 2, 10, 5};
     *
     * current is 35 now compared w/ 50 swap! 1 35 50 45 2 10 5 current is 45
     * now compared w/ 50 swap! 1 35 45 50 2 10 5 current is 2 now compared w/
     * 50 swap! 1 35 45 2 50 10 5 current is 2 now compared w/ 45 swap! 1 35 2
     * 45 50 10 5 current is 2 now compared w/ 35 swap! 1 2 35 45 50 10 5
     * current is 10 now compared w/ 50 swap! 1 2 35 45 10 50 5 current is 10
     * now compared w/ 45 swap! 1 2 35 10 45 50 5 current is 10 now compared
     * w/35 swap! 1 2 10 35 45 50 5 current is 5 now compared w/ 50 swap! 1 2 10
     * 35 45 5 50 current is 5 now compared w/ 45 swap! 1 2 10 35 5 45 50
     * current is 5 now compared w/ 35 swap! 1 2 10 5 35 45 50 current is 5 now
     * compared w/ 10 swap! 1 2 5 10 35 45 50
     *
     * @param A
     * @return A
     */
    public static int[] insertSort(int[] A) {
        int ptrCurrent;

        for (int x = 0; x < A.length; x++) {
            ptrCurrent = x;

            for (int i = ptrCurrent; i >= 0; i--) {

                if (A[ptrCurrent] < A[i]) {
                    //System.out.println("\n current is " + A[ptrCurrent] + " now compared w/ " + A[i]);
                    ptrCurrent = i;//?
                    swap(A, i, ptrCurrent);
                }
            }

        }
        System.out.println();
        return A;
    }

    static private int[] removeElement(int index, int[] list) {

        int[] newList = new int[list.length - 1];

        int j = 0;

        for (int i = 0; i < list.length; i++) {

            if (index != i) {

                newList[j] = list[i];

                j++;

            }

        }

        return newList;

    }

    

    static private int[] appendFrom(int[] list, int[] appendList, int start){

        int j =0;

        

        for (int i = start; i < list.length; i++, j++) {

            list[i] = appendList[j];

        }



        return list;

    }



    static public int[] merge(int[] left, int[] right) {

        int[] collection = new int[left.length + right.length];

        int j = 0;



        while (left.length != 0 && right.length != 0) {

            int i = 0;

            if (left[i] > right[i]) {

                System.out.println(left[i]);

                collection[j] = left[i];

                left = removeElement(i, left);

            } else {

                 System.out.println(right[i]);

                collection[j] = right[i];

                right = removeElement(i, right);

            }

            j++;

        }



        if (left.length != 0) {

            collection = appendFrom(collection, left,j);

            // newList.addAll(left);

        }

        if (right.length != 0) {

            collection = appendFrom(collection, right,j);

        }



        return collection;

    }



    static private int[] splitArray(int[] list, int start, int end) {

        int[] newList = new int[end - start];

        int j = 0;

        for (int i = start; i < end; i++) {

            newList[j] = list[i];

            j++;

        }

        return newList;

    }


    /**
     * partition, sort, then merge. partitions of 2n
     *
     * @param list
     * @return A
     */
    static public int[] mergeSort(int[] list) {

        if (list.length == 1) {

            return list;

        }

        int midPoint = list.length / 2;

        int[] leftHalf = splitArray(list, 0, midPoint);

        int[] rightHalf = splitArray(list, midPoint, list.length);

        leftHalf = mergeSort(leftHalf);

        rightHalf = mergeSort(rightHalf);



        return merge(leftHalf, rightHalf);

    }

}
