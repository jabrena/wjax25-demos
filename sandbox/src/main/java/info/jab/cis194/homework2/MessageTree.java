package info.jab.cis194.homework2;

/**
 * Represents a binary search tree of log messages, ordered by timestamp.
 * This is an algebraic data type with two variants: Leaf and Node.
 */
public sealed interface MessageTree {
    record Leaf() implements MessageTree {}
    record Node(MessageTree left, LogMessage.ValidLogMessage logMessage, MessageTree right) implements MessageTree {}
}
