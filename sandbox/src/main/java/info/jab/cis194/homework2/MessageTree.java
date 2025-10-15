package info.jab.cis194.homework2;

/**
 * Represents a binary search tree of log messages.
 * Based on the Haskell MessageTree from Log.hs
 */
public class MessageTree {
    private final LogMessage message;
    private final MessageTree left;
    private final MessageTree right;
    private final boolean isLeaf;
    
    // Constructor for leaf (empty tree)
    public MessageTree() {
        this.message = null;
        this.left = null;
        this.right = null;
        this.isLeaf = true;
    }
    
    // Constructor for node with message and subtrees
    public MessageTree(MessageTree left, LogMessage message, MessageTree right) {
        this.message = message;
        this.left = left;
        this.right = right;
        this.isLeaf = false;
    }
    
    public LogMessage getMessage() {
        return message;
    }
    
    public MessageTree getLeft() {
        return left;
    }
    
    public MessageTree getRight() {
        return right;
    }
    
    public boolean isLeaf() {
        return isLeaf;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        MessageTree that = (MessageTree) obj;
        
        if (isLeaf != that.isLeaf) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        return right != null ? right.equals(that.right) : that.right == null;
    }
    
    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (isLeaf ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        if (isLeaf) {
            return "Leaf";
        } else {
            return "Node(" + left + ", " + message + ", " + right + ")";
        }
    }
}