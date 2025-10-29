package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for Exercise 4: inOrder function
 */
public class Exercise4Test {
    
    @Test
    public void testInOrderEmptyTree() {
        MessageTree tree = new MessageTree.Leaf();
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testInOrderSingleNode() {
        LogMessage message = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "single"
        );
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), message, new MessageTree.Leaf()
        );
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(1, result.size());
        assertEquals(message, result.get(0));
    }
    
    @Test
    public void testInOrderThreeNodes() {
        LogMessage leftMessage = new LogMessage.LogMessageData(
            new MessageType.Info(), 5, "left"
        );
        LogMessage rootMessage = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "root"
        );
        LogMessage rightMessage = new LogMessage.LogMessageData(
            new MessageType.Info(), 15, "right"
        );
        
        MessageTree leftSubtree = new MessageTree.Node(
            new MessageTree.Leaf(), leftMessage, new MessageTree.Leaf()
        );
        MessageTree rightSubtree = new MessageTree.Node(
            new MessageTree.Leaf(), rightMessage, new MessageTree.Leaf()
        );
        MessageTree tree = new MessageTree.Node(leftSubtree, rootMessage, rightSubtree);
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(leftMessage, result.get(0));  // timestamp 5
        assertEquals(rootMessage, result.get(1));  // timestamp 10
        assertEquals(rightMessage, result.get(2)); // timestamp 15
    }
    
    @Test
    public void testInOrderComplexTree() {
        // Build a more complex tree: 10 -> (5 -> (1, 7), 20 -> (15, 25))
        LogMessage message1 = new LogMessage.LogMessageData(
            new MessageType.Info(), 1, "msg1"
        );
        LogMessage message5 = new LogMessage.LogMessageData(
            new MessageType.Info(), 5, "msg5"
        );
        LogMessage message7 = new LogMessage.LogMessageData(
            new MessageType.Info(), 7, "msg7"
        );
        LogMessage message10 = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "msg10"
        );
        LogMessage message15 = new LogMessage.LogMessageData(
            new MessageType.Info(), 15, "msg15"
        );
        LogMessage message20 = new LogMessage.LogMessageData(
            new MessageType.Info(), 20, "msg20"
        );
        LogMessage message25 = new LogMessage.LogMessageData(
            new MessageType.Info(), 25, "msg25"
        );
        
        MessageTree leaf1 = new MessageTree.Node(
            new MessageTree.Leaf(), message1, new MessageTree.Leaf()
        );
        MessageTree leaf7 = new MessageTree.Node(
            new MessageTree.Leaf(), message7, new MessageTree.Leaf()
        );
        MessageTree leaf15 = new MessageTree.Node(
            new MessageTree.Leaf(), message15, new MessageTree.Leaf()
        );
        MessageTree leaf25 = new MessageTree.Node(
            new MessageTree.Leaf(), message25, new MessageTree.Leaf()
        );
        
        MessageTree subtree5 = new MessageTree.Node(leaf1, message5, leaf7);
        MessageTree subtree20 = new MessageTree.Node(leaf15, message20, leaf25);
        MessageTree tree = new MessageTree.Node(subtree5, message10, subtree20);
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(7, result.size());
        assertEquals(message1, result.get(0));   // timestamp 1
        assertEquals(message5, result.get(1));   // timestamp 5
        assertEquals(message7, result.get(2));   // timestamp 7
        assertEquals(message10, result.get(3));  // timestamp 10
        assertEquals(message15, result.get(4));  // timestamp 15
        assertEquals(message20, result.get(5));  // timestamp 20
        assertEquals(message25, result.get(6));  // timestamp 25
    }
    
    @Test
    public void testInOrderWithDifferentMessageTypes() {
        LogMessage infoMessage = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "info"
        );
        LogMessage warningMessage = new LogMessage.LogMessageData(
            new MessageType.Warning(), 5, "warning"
        );
        LogMessage errorMessage = new LogMessage.LogMessageData(
            new MessageType.Error(50), 15, "error"
        );
        
        List<LogMessage> messages = new ArrayList<>();
        messages.add(infoMessage);
        messages.add(warningMessage);
        messages.add(errorMessage);
        
        MessageTree tree = LogAnalysis.build(messages);
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(warningMessage, result.get(0)); // timestamp 5
        assertEquals(infoMessage, result.get(1));    // timestamp 10
        assertEquals(errorMessage, result.get(2));   // timestamp 15
    }
}