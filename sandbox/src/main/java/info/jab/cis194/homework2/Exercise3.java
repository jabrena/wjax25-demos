package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3: Traverse the binary search tree in order.
 * 
 * This exercise involves performing an in-order traversal of the MessageTree
 * to get all messages in chronological order.
 */
public class Exercise3 {
    
    /**
     * Perform an in-order traversal of the MessageTree.
     * 
     * @param tree the tree to traverse
     * @return a list of LogMessages in chronological order (by timestamp)
     */
    public static List<LogMessage> inOrder(MessageTree tree) {
        List<LogMessage> result = new ArrayList<>();
        inOrderHelper(tree, result);
        return result;
    }
    
    /**
     * Helper method to perform the actual in-order traversal.
     * 
     * @param tree the current subtree
     * @param result the list to accumulate results
     */
    private static void inOrderHelper(MessageTree tree, List<LogMessage> result) {
        if (tree instanceof MessageTree.Leaf) {
            return;
        }
        
        if (tree instanceof MessageTree.Node) {
            MessageTree.Node node = (MessageTree.Node) tree;
            
            // Visit left subtree
            inOrderHelper(node.getLeft(), result);
            
            // Visit current node
            result.add(node.getMessage());
            
            // Visit right subtree
            inOrderHelper(node.getRight(), result);
        }
    }
}