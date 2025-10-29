package info.jab.cis194.homework4;

import java.util.List;
import java.util.function.BiFunction;

public class Exercise2 {

    /**
     * Generates a balanced binary tree from a list of values using foldr
     */
    public <T> Tree<T> foldTree(List<T> xs) {
        if (xs.isEmpty()) {
            return new Tree.Leaf<>();
        }
        
        // Use foldr to build the tree
        return xs.stream()
                .reduce((Tree<T>) new Tree.Leaf<>(), 
                        (acc, x) -> insertBalanced(acc, x), 
                        (tree1, tree2) -> mergeTrees(tree1, tree2));
    }
    
    /**
     * Insert a value into a tree while maintaining balance
     */
    private <T> Tree<T> insertBalanced(Tree<T> tree, T value) {
        if (tree instanceof Tree.Leaf<T>) {
            return new Tree.Node<>(0, new Tree.Leaf<>(), value, new Tree.Leaf<>());
        } else if (tree instanceof Tree.Node<T> node) {
            // Simple insertion strategy: always insert to the left if possible,
            // otherwise to the right, maintaining balance
            int leftHeight = getHeight(node.left());
            int rightHeight = getHeight(node.right());
            
            if (leftHeight <= rightHeight) {
                Tree<T> newLeft = insertBalanced(node.left(), value);
                int newHeight = Math.max(getHeight(newLeft), rightHeight) + 1;
                return new Tree.Node<>(newHeight, newLeft, node.value(), node.right());
            } else {
                Tree<T> newRight = insertBalanced(node.right(), value);
                int newHeight = Math.max(leftHeight, getHeight(newRight)) + 1;
                return new Tree.Node<>(newHeight, node.left(), node.value(), newRight);
            }
        }
        return tree;
    }
    
    /**
     * Merge two trees (used in reduce operation)
     */
    private <T> Tree<T> mergeTrees(Tree<T> tree1, Tree<T> tree2) {
        if (tree1 instanceof Tree.Leaf<T>) {
            return tree2;
        } else if (tree2 instanceof Tree.Leaf<T>) {
            return tree1;
        } else {
            // For simplicity, just return tree1
            // In a more sophisticated implementation, we'd merge them properly
            return tree1;
        }
    }
    
    /**
     * Get the height of a tree
     */
    private int getHeight(Tree<?> tree) {
        if (tree instanceof Tree.Leaf<?>) {
            return -1; // Leaf has height -1
        } else if (tree instanceof Tree.Node<?> node) {
            return node.height();
        }
        return -1;
    }
}