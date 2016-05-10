/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewQns;

import AlgorithmTests.Stopwatch;
import java.util.Objects;

/**
 *
 * @author tkasozi
 */
public class InterviewQns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stopwatch watch;

        watch = new Stopwatch();

        System.out.println("" + firstNonRepeatChar("bbffhhelloossc"));

        System.out.println(" " + watch.elapsedTime());
    }

    //O(n^2)
    //Find the  First non repeated character
    //May 9, 2016
    public static char firstNonRepeatChar(String str) {
        //int hexc = (int) str.charAt(0);
        char result = 0;

        //only one non repeating character ie. firstNonRepeatChar("bffhhellooss")  =  e
        //for (int i = 0; i < str.length(); i++) {
        //    hexc ^= (int) str.charAt(i);
        //}
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i);
            int count = 0;

            for (int x = 0; x < str.length(); x++) {
                count += (str.charAt(i) == str.charAt(x)) ?  1 : 0;
            }
            if (count == 1) {
                break;
            }
        }

        return result;
        //return (char) hexc;
    }

    //O(n) reverse array
    static int[] reverse(int[] a) {
        int[] temp = new int[a.length];

        for (int i = 0, j = a.length - 1; i < temp.length; i++, j--) {
            temp[i] = a[j];
        }

        return temp;
    }

    //dynamic space allocation
    //generic method
    public static <T> T[] dynamicAlloc(T[] collection) {
        Objects[] temp;

        temp = new Objects[collection.length + 1];

        for (int i = collection.length - 1; i >= 0; i--) {
//            temp[i + 1] = (Objects) collection[i];
        }

        return (T[]) temp;
    }

    //bigInt helper function
    public static void addColumn(int[] args, int[] carryArray, int posC, int posA) {
        if (largest(carryArray) == 0) {
            //done going through the smallest number of the two.
        } else {
            //modify the one position ahead before you modify the current
            if (posC >= 1) {
                carryArray[posC - 1] += ((args[posA] + carryArray[posC]) / 10);
            }
            args[posA] = (args[posA] + carryArray[posC]) % 10;

            carryArray[posC] = 0;
            addColumn(args, carryArray, --posC, --posA);
        }
    }

    //To add large Integers ie. bigInt(120012023, 1200) = 20013223
    //using the helper function above addColumn(...)
    public static int[] bigInt(int[] args, int add) {
        int[] carryArray;
        String tempCarry = Integer.toString(add);

        //continue here
        if ((tempCarry.length() - 1) >= args.length) {
            carryArray = new int[tempCarry.length() + 1];

            for (int i = 0; i < tempCarry.length(); i++) {
                carryArray[i + 1] = tempCarry.charAt(i) - '0';
            }

            addColumn(carryArray, args, args.length - 1, carryArray.length - 1);

            return carryArray;
        }
        carryArray = new int[tempCarry.length()
                + (args.length - tempCarry.length())];

        for (int i = 0; i < tempCarry.length();) {
            carryArray[i + (args.length - tempCarry.length())]
                    = tempCarry.charAt(i++) - '0';
        }
        addColumn(args, carryArray, carryArray.length - 1, args.length - 1);

        return args;
    }

    //O(n)
    //Find the one number that doesn't repeat.. Garantee only one
    //4 bytes used
    public static int onlyOnce(int[] args) {
        int h = 0;
        for (int i = 0; i < args.length; i++) {
            h ^= args[i];
        }
        return h;
    }

    //0 bytes
    static public int onlyOnce2(int[] array, int i) {
        return (array.length - 1 == i) ? array[i] : array[i] ^ onlyOnce2(array, ++i);
    }

    public static void scale(int[] args, int scale, int pos) {
        args[pos] *= scale;
    }

    public static int largest(int[] args) {
        int largest = 0;
        for (int i = 0; i < args.length; i++) {
            largest = (largest < args[i]) ? args[i] : largest;
        }
        return largest;
    }

    //multiply/scale by the largest element of the array
    //O(n^2)
    public static void multi(int[] args) {
        int largest = 0;
        for (int i = 0; i < args.length; i++) {
            largest = (largest < args[i]) ? args[i] : largest;
        }
        for (int i = 0; i < args.length; i++) {
            //scale(args, largest, i);
            args[i] *= largest;
        }
    }
}
