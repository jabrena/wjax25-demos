package info.jab.cis194.homework4;

/**
 * Binary tree data structure with height information.
 * Each node stores an extra Integer representing the height at that node.
 * 
 * This corresponds to the Haskell data structure:
 * data Tree a = Leaf | Node Integer (Tree a) a (Tree a)
 */
public class Tree<T> {
    private final Integer height;
    private final Tree<T> left;
    private final T value;
    private final Tree<T> right;

    // Private constructor for internal use
    private Tree(Integer height, Tree<T> left, T value, Tree<T> right) {
        this.height = height;
        this.left = left;
        this.value = value;
        this.right = right;
    }

    // Factory method for creating a leaf node
    public static <T> Tree<T> leaf(T value) {
        return new Tree<>(0, null, value, null);
    }

    // Factory method for creating an internal node
    public static <T> Tree<T> node(Integer height, Tree<T> left, T value, Tree<T> right) {
        return new Tree<>(height, left, value, right);
    }

    // Check if this is a leaf node
    public boolean isLeaf() {
        return left == null && right == null;
    }

    // Check if this is a null tree
    public boolean isNull() {
        return this == null;
    }

    // Getters
    public Integer getHeight() {
        return height;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public T getValue() {
        return value;
    }

    public Tree<T> getRight() {
        return right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Tree<?> tree = (Tree<?>) obj;
        
        if (height != null ? !height.equals(tree.height) : tree.height != null) return false;
        if (left != null ? !left.equals(tree.left) : tree.left != null) return false;
        if (value != null ? !value.equals(tree.value) : tree.value != null) return false;
        return right != null ? right.equals(tree.right) : tree.right == null;
    }

    @Override
    public int hashCode() {
        int result = height != null ? height.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            return "Leaf(" + value + ")";
        } else {
            return "Node(" + height + ", " + left + ", " + value + ", " + right + ")";
        }
    }
}