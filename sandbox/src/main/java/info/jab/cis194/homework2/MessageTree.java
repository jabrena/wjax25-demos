package info.jab.cis194.homework2;

/**
 * Represents a binary search tree of LogMessages.
 * Equivalent to the Haskell MessageTree data type.
 */
public sealed interface MessageTree permits MessageTree.Leaf, MessageTree.Node {
    
    record Leaf() implements MessageTree {
        @Override
        public String toString() {
            return "Leaf";
        }
    }
    
    record Node(MessageTree left, LogMessage message, MessageTree right) implements MessageTree {
        @Override
        public String toString() {
            return "Node(" + left + ", " + message + ", " + right + ")";
        }
    }
}