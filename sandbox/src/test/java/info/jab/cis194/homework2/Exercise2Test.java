package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 2: insert function
 */
public class Exercise2Test {
    
    @Test
    public void testInsertIntoEmptyTree() {
        LogMessage message = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "test message");
        MessageTree tree = new MessageTree.Leaf();
        
        MessageTree result = LogAnalysis.insert(message, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message, node.message());
        assertTrue(node.left() instanceof MessageTree.Leaf);
        assertTrue(node.right() instanceof MessageTree.Leaf);
    }
    
    @Test
    public void testInsertUnknownMessage() {
        LogMessage unknownMessage = new LogMessage.Unknown("unknown message");
        MessageTree tree = new MessageTree.Leaf();
        
        MessageTree result = LogAnalysis.insert(unknownMessage, tree);
        
        // Unknown messages should not be stored, so tree should remain unchanged
        assertTrue(result instanceof MessageTree.Leaf);
    }
    
    @Test
    public void testInsertSmallerTimestamp() {
        LogMessage existingMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 20, "existing");
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), existingMessage, new MessageTree.Leaf());
        
        LogMessage newMessage = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 10, "new");
        
        MessageTree result = LogAnalysis.insert(newMessage, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(existingMessage, node.message());
        assertTrue(node.left() instanceof MessageTree.Node);
        assertTrue(node.right() instanceof MessageTree.Leaf);
        
        MessageTree.Node leftNode = (MessageTree.Node) node.left();
        assertEquals(newMessage, leftNode.message());
    }
    
    @Test
    public void testInsertLargerTimestamp() {
        LogMessage existingMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "existing");
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), existingMessage, new MessageTree.Leaf());
        
        LogMessage newMessage = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 20, "new");
        
        MessageTree result = LogAnalysis.insert(newMessage, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(existingMessage, node.message());
        assertTrue(node.left() instanceof MessageTree.Leaf);
        assertTrue(node.right() instanceof MessageTree.Node);
        
        MessageTree.Node rightNode = (MessageTree.Node) node.right();
        assertEquals(newMessage, rightNode.message());
    }
    
    @Test
    public void testInsertEqualTimestamp() {
        LogMessage existingMessage = new LogMessage.LogMessageRecord(
            new MessageType.Info(), 10, "existing");
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), existingMessage, new MessageTree.Leaf());
        
        LogMessage newMessage = new LogMessage.LogMessageRecord(
            new MessageType.Warning(), 10, "new");
        
        MessageTree result = LogAnalysis.insert(newMessage, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(existingMessage, node.message());
        assertTrue(node.left() instanceof MessageTree.Leaf);
        assertTrue(node.right() instanceof MessageTree.Node);
        
        MessageTree.Node rightNode = (MessageTree.Node) node.right();
        assertEquals(newMessage, rightNode.message());
    }
}