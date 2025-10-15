package info.jab.cis194.homework2;

import java.util.List;

/**
 * Exercise 2: Build a binary search tree from log messages.
 * 
 * This exercise involves inserting LogMessage objects into a binary search tree
 * ordered by timestamp, and building a tree from a list of messages.
 */
public class Exercise2 {
    
    /**
     * Insert a LogMessage into a MessageTree, maintaining BST property by timestamp.
     * 
     * @param message the message to insert
     * @param tree the tree to insert into
     * @return a new tree with the message inserted
     */
    public static MessageTree insert(LogMessage message, MessageTree tree) {
        if (tree instanceof MessageTree.Leaf) {
            return new MessageTree.Node(
                new MessageTree.Leaf(),
                message,
                new MessageTree.Leaf()
            );
        }
        
        if (tree instanceof MessageTree.Node) {
            MessageTree.Node node = (MessageTree.Node) tree;
            int messageTimestamp = getTimestamp(message);
            int nodeTimestamp = getTimestamp(node.getMessage());
            
            if (messageTimestamp <= nodeTimestamp) {
                return new MessageTree.Node(
                    insert(message, node.getLeft()),
                    node.getMessage(),
                    node.getRight()
                );
            } else {
                return new MessageTree.Node(
                    node.getLeft(),
                    node.getMessage(),
                    insert(message, node.getRight())
                );
            }
        }
        
        // This should never happen, but return the original tree
        return tree;
    }
    
    /**
     * Build a binary search tree from a list of LogMessages.
     * 
     * @param messages the list of messages to build the tree from
     * @return a binary search tree containing all the messages
     */
    public static MessageTree buildTree(List<LogMessage> messages) {
        MessageTree tree = new MessageTree.Leaf();
        
        for (LogMessage message : messages) {
            tree = insert(message, tree);
        }
        
        return tree;
    }
    
    /**
     * Get the timestamp from a LogMessage.
     * 
     * @param message the message to get timestamp from
     * @return the timestamp, or Integer.MAX_VALUE for unknown messages
     */
    private static int getTimestamp(LogMessage message) {
        if (message instanceof LogMessage.InfoMessage) {
            return ((LogMessage.InfoMessage) message).getTimestamp();
        } else if (message instanceof LogMessage.WarningMessage) {
            return ((LogMessage.WarningMessage) message).getTimestamp();
        } else if (message instanceof LogMessage.ErrorMessage) {
            return ((LogMessage.ErrorMessage) message).getTimestamp();
        } else {
            // Unknown messages go to the end
            return Integer.MAX_VALUE;
        }
    }
}