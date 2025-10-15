package info.jab.cis194.homework2;

/**
 * Represents a binary search tree for storing LogMessage objects.
 * This is the Java equivalent of the Haskell algebraic data type.
 */
public abstract class MessageTree {
    
    /**
     * Empty tree (leaf node).
     */
    public static class Leaf extends MessageTree {
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Leaf;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public String toString() {
            return "Leaf";
        }
    }
    
    /**
     * Node containing a LogMessage and two subtrees.
     */
    public static class Node extends MessageTree {
        private final MessageTree left;
        private final LogMessage message;
        private final MessageTree right;
        
        public Node(MessageTree left, LogMessage message, MessageTree right) {
            this.left = left;
            this.message = message;
            this.right = right;
        }
        
        public MessageTree getLeft() {
            return left;
        }
        
        public LogMessage getMessage() {
            return message;
        }
        
        public MessageTree getRight() {
            return right;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return java.util.Objects.equals(left, node.left) &&
                   java.util.Objects.equals(message, node.message) &&
                   java.util.Objects.equals(right, node.right);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(left, message, right);
        }
        
        @Override
        public String toString() {
            return "Node{left=" + left + ", message=" + message + ", right=" + right + "}";
        }
    }
}