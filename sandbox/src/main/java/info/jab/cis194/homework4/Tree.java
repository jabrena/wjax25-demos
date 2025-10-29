package info.jab.cis194.homework4;

/**
 * Binary tree data structure with height information
 */
public sealed interface Tree<T> {
    
    /**
     * Leaf node (empty tree)
     */
    record Leaf<T>() implements Tree<T> {}
    
    /**
     * Node with height, left subtree, value, and right subtree
     */
    record Node<T>(int height, Tree<T> left, T value, Tree<T> right) implements Tree<T> {}
}