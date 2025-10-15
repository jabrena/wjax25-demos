package info.jab.cis194.homework4;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Exercise2 {

    /**
     * Creates a balanced binary tree from a list of values using foldr.
     * 
     * The algorithm works by:
     * 1. Starting with an empty tree (null)
     * 2. For each element in the list, insert it into the tree
     * 3. Maintain balance by ensuring the height difference between left and right subtrees is at most 1
     * 
     * @param list The list of values to create a tree from
     * @return A balanced binary tree containing all values from the list, or null if list is empty
     */
    public static <T> Tree<T> foldTree(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        // Use the simple approach which is more reliable
        return foldTreeSimple(list);
    }

    /**
     * Inserts a value into a balanced tree, maintaining balance.
     * 
     * @param tree The existing tree (can be null)
     * @param value The value to insert
     * @return A new balanced tree containing the value
     */
    private static <T> Tree<T> insert(Tree<T> tree, T value) {
        if (tree == null) {
            return Tree.leaf(value);
        }

        // Insert into the shorter subtree to maintain balance
        int leftHeight = tree.getLeft() != null ? tree.getLeft().getHeight() : -1;
        int rightHeight = tree.getRight() != null ? tree.getRight().getHeight() : -1;

        if (leftHeight <= rightHeight) {
            // Insert into left subtree
            Tree<T> newLeft = insert(tree.getLeft(), value);
            int newLeftHeight = newLeft != null ? newLeft.getHeight() : -1;
            int newHeight = Math.max(newLeftHeight, rightHeight) + 1;
            return Tree.node(newHeight, newLeft, tree.getValue(), tree.getRight());
        } else {
            // Insert into right subtree
            Tree<T> newRight = insert(tree.getRight(), value);
            int newRightHeight = newRight != null ? newRight.getHeight() : -1;
            int newHeight = Math.max(leftHeight, newRightHeight) + 1;
            return Tree.node(newHeight, tree.getLeft(), tree.getValue(), newRight);
        }
    }

    /**
     * Merges two trees. This is used by the reduce operation.
     * In practice, we only use the first tree since we're building incrementally.
     * 
     * @param tree1 The first tree
     * @param tree2 The second tree (ignored in this implementation)
     * @return The first tree
     */
    private static <T> Tree<T> merge(Tree<T> tree1, Tree<T> tree2) {
        return tree1; // We only use the first tree in our foldr implementation
    }

    /**
     * Alternative implementation using a more functional approach.
     * This creates a balanced tree by building it level by level.
     */
    public static <T> Tree<T> foldTreeFunctional(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        // Convert list to array for easier indexing
        @SuppressWarnings("unchecked")
        T[] array = (T[]) list.toArray();
        int n = array.length;

        // Build tree level by level
        return buildTree(array, 0, n - 1);
    }

    /**
     * Recursively builds a balanced tree from a sorted array.
     * 
     * @param array The sorted array of values
     * @param start The start index
     * @param end The end index
     * @return A balanced tree containing elements from start to end
     */
    private static <T> Tree<T> buildTree(T[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return Tree.leaf(array[start]);
        }

        // Find the middle element
        int mid = start + (end - start) / 2;

        // Recursively build left and right subtrees
        Tree<T> left = buildTree(array, start, mid - 1);
        Tree<T> right = buildTree(array, mid + 1, end);

        // Calculate height
        int leftHeight = left != null ? left.getHeight() : -1;
        int rightHeight = right != null ? right.getHeight() : -1;
        int height = Math.max(leftHeight, rightHeight) + 1;

        return Tree.node(height, left, array[mid], right);
    }

    /**
     * Simple implementation that builds a balanced tree by inserting elements one by one.
     * This is more straightforward and should work correctly.
     */
    public static <T> Tree<T> foldTreeSimple(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        Tree<T> result = null;
        for (T value : list) {
            result = insertSimple(result, value);
        }
        return result;
    }

    /**
     * Simple insertion that maintains balance by always inserting into the shorter subtree.
     */
    private static <T> Tree<T> insertSimple(Tree<T> tree, T value) {
        if (tree == null) {
            return Tree.leaf(value);
        }

        // Insert into the shorter subtree to maintain balance
        int leftHeight = tree.getLeft() != null ? tree.getLeft().getHeight() : -1;
        int rightHeight = tree.getRight() != null ? tree.getRight().getHeight() : -1;

        if (leftHeight <= rightHeight) {
            // Insert into left subtree
            Tree<T> newLeft = insertSimple(tree.getLeft(), value);
            int newLeftHeight = newLeft != null ? newLeft.getHeight() : -1;
            int newHeight = Math.max(newLeftHeight, rightHeight) + 1;
            return Tree.node(newHeight, newLeft, tree.getValue(), tree.getRight());
        } else {
            // Insert into right subtree
            Tree<T> newRight = insertSimple(tree.getRight(), value);
            int newRightHeight = newRight != null ? newRight.getHeight() : -1;
            int newHeight = Math.max(leftHeight, newRightHeight) + 1;
            return Tree.node(newHeight, tree.getLeft(), tree.getValue(), newRight);
        }
    }
}