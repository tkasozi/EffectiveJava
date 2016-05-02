/**
 *
 * Testing algorithms
 */
package AlgorithmTests;

import DataStructures.BinaryTree;
import java.util.Arrays;

/**
 *
 * @author tkasozi
 */
public class algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(4);

        binaryTree.insert(1);
        binaryTree.insert(5);

        //binaryTree.traverse(binaryTree, true);
        
        binaryTree.print();

    }

    public static void main_(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 34, 56, 7, 89, 90, 0, 1100})));
    }

    //O(n)
    static int[] reverse(int[] a) {
        int[] temp = new int[a.length];

        for (int i = 0, j = a.length - 1; i < temp.length; i++, j--) {
            temp[i] = a[j];
        }

        return temp;
    }
}
