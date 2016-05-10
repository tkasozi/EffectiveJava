/**
 *
 * Testing algorithms
 */
package AlgorithmTests;

import DataStructures.BinaryTree;
import static InterviewQns.InterviewQns.firstNonRepeatChar;
import java.util.Iterator;

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
        binaryTree.insert(6);
        binaryTree.insert(7);

        Stopwatch watch;

        watch = new Stopwatch();

        System.out.println("" + firstNonRepeatChar("bbffhhelloossc"));

        System.out.println(" " + watch.elapsedTime());
    }
}
