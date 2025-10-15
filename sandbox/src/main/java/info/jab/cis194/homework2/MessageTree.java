package info.jab.cis194.homework2;

/**
 * Represents a binary search tree of log messages.
 * This is equivalent to the Haskell MessageTree data type.
 */
public sealed interface MessageTree {
    
    /**
     * An empty tree (leaf node)
     */
    record Leaf() implements MessageTree {
        @Override
        public String toString() {
            return "Leaf";
        }
    }
    
    /**
     * A node containing a log message and two subtrees
     * @param left the left subtree
     * @param message the log message stored in this node
     * @param right the right subtree
     */
    record Node(MessageTree left, LogMessage message, MessageTree right) implements MessageTree {
        @Override
        public String toString() {
            return "Node(" + left + ", " + message + ", " + right + ")";
        }
    }
}