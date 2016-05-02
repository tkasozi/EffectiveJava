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
        binaryTree.insert(2);
        binaryTree.insert(3);

        //binaryTree.traverse(binaryTree, true);
        //binaryTree.print();
        for (Integer T : binaryTree) {
            System.out.print(T + " ");
        }
    }
}
