/**
 * Binary Tree Implementation
 *
 *
 * <talik.aziizi@gmail.com>
 *
 * April 2, 2016
 */
package DataStructures;

import java.util.Iterator;

/**
 *
 * @author tkasozi
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    BinaryTree<T> leftBranch;
    BinaryTree<T> parent;
    BinaryTree<T> rightBranch;

    T data;

    public BinaryTree(T data) {

        this.data = data;
    }

    public boolean contains(T target) {

        if (data.compareTo(target) == 0) {
            return true;
        } else if (data.compareTo(target) < 0 && this.leftBranch != null) {
            return this.leftBranch.contains(target);
        } else if (data.compareTo(target) > 0 && this.rightBranch != null) {
            return this.rightBranch.contains(target);
        }
        return false;
    }

    //TODO  implement a non recursive insert method
    //here below
    public void add(T target) {

    }

    //recursive version of add
    //this function works in the same way as add()
    public void insert(T target) {

        if (data.compareTo(target) == 0) {
            //do nothing
        } else if (data.compareTo(target) < 0) {
            //node is less than the new data... ie. put rightBranch.
            if (this.rightBranch == null) {
                this.rightBranch = new BinaryTree<>(target);
                this.rightBranch.parent = this;
            } else {
                this.rightBranch.insert(target);
            }

        } else if (data.compareTo(target) > 0) {
            //put leftBranch
            if (this.leftBranch == null) {
                this.leftBranch = new BinaryTree<>(target);
                this.leftBranch.parent = this;
            } else {
                this.leftBranch.insert(target);
            }
        }
    }

    public boolean traverse(BinaryTree T, boolean rc) {
        //1. lowest-Left ie. if the left is null then this.isSmallest
        //2. largest-Right ie. if the right is null then this.isLargest
        //rc = return call
        if (T == null) {
            //done otherwise return
            return false;
        } else {
            rc = (T.data != null);

            if (rc) {
                rc = traverse(T.leftBranch, rc);
            }
            if (!rc) {
                System.out.print(T.data + " ");
                //System.out.print(T.data + " ");
                traverse(T.rightBranch, rc);
            }

            return rc;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterate(this);
    }

    private class Iterate implements Iterator<T> {

        private BinaryTree<T> tree, left, right;
//        private final T root;

        public Iterate(BinaryTree<T> T) {
            this.tree = T.parent;
        }

        @Override
        public T next() {
            return this.tree.data;
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return !(this.tree == null);
        }

    }

    public void print() {
        Iterator<T> iter = this.leftBranch.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

}
