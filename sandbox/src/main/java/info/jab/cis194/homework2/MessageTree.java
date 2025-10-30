package info.jab.cis194.homework2;

final class MessageTree {
    final MessageTree left;
    final LogMessage message; // null for leaf
    final MessageTree right;

    private MessageTree(MessageTree left, LogMessage message, MessageTree right) {
        this.left = left;
        this.message = message;
        this.right = right;
    }

    static MessageTree leaf() {
        return new MessageTree(null, null, null);
    }

    static MessageTree node(MessageTree left, LogMessage message, MessageTree right) {
        return new MessageTree(left, message, right);
    }

    boolean isLeaf() {
        return message == null;
    }
}
