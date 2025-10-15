package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 4: inOrder function
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
        LogMessage message = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "single message");
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), message, new MessageTree.Leaf());
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(1, result.size());
        assertEquals(message, result.get(0));
    }
    
    @Test
    public void testInOrderLeftSubtree() {
        LogMessage leftMessage = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 5, "left");
        LogMessage rootMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "root");
        
        MessageTree leftTree = new MessageTree.Node(
            new MessageTree.Leaf(), leftMessage, new MessageTree.Leaf());
        MessageTree tree = new MessageTree.Node(
            leftTree, rootMessage, new MessageTree.Leaf());
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(2, result.size());
        assertEquals(leftMessage, result.get(0));
        assertEquals(rootMessage, result.get(1));
    }
    
    @Test
    public void testInOrderRightSubtree() {
        LogMessage rootMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "root");
        LogMessage rightMessage = new LogMessage.LogMessageRecord(
            new MessageType.Error(5), 15, "right");
        
        MessageTree rightTree = new MessageTree.Node(
            new MessageTree.Leaf(), rightMessage, new MessageTree.Leaf());
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), rootMessage, rightTree);
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(2, result.size());
        assertEquals(rootMessage, result.get(0));
        assertEquals(rightMessage, result.get(1));
    }
    
    @Test
    public void testInOrderFullTree() {
        LogMessage leftMessage = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 5, "left");
        LogMessage rootMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "root");
        LogMessage rightMessage = new LogMessage.LogMessageRecord(
            new MessageType.Error(5), 15, "right");
        
        MessageTree leftTree = new MessageTree.Node(
            new MessageTree.Leaf(), leftMessage, new MessageTree.Leaf());
        MessageTree rightTree = new MessageTree.Node(
            new MessageTree.Leaf(), rightMessage, new MessageTree.Leaf());
        MessageTree tree = new MessageTree.Node(
            leftTree, rootMessage, rightTree);
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(leftMessage, result.get(0));
        assertEquals(rootMessage, result.get(1));
        assertEquals(rightMessage, result.get(2));
    }
    
    @Test
    public void testInOrderSortedByTimestamp() {
        // Create a tree with messages in random order
        LogMessage message1 = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 30, "third");
        LogMessage message2 = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 10, "first");
        LogMessage message3 = new LogMessage.LogMessageRecord(
            new MessageType.Error(5), 20, "second");
        
        // Build tree from messages
        MessageTree tree = LogAnalysis.build(List.of(message1, message2, message3));
        
        List<LogMessage> result = LogAnalysis.inOrder(tree);
        
        assertEquals(3, result.size());
        
        // Check that timestamps are in ascending order
        for (int i = 0; i < result.size() - 1; i++) {
            LogMessage current = result.get(i);
            LogMessage next = result.get(i + 1);
            
            if (current instanceof LogMessage.LogMessageRecord currentLog &&
                next instanceof LogMessage.LogMessageRecord nextLog) {
                assertTrue(currentLog.timestamp() <= nextLog.timestamp());
            }
        }
    }
}