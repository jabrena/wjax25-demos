package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for Exercise 3: build function
 */
public class Exercise3Test {
    
    @Test
    public void testBuildEmptyList() {
        List<LogMessage> messages = new ArrayList<>();
        MessageTree result = LogAnalysis.build(messages);
        
        assertTrue(result instanceof MessageTree.Leaf);
    }
    
    @Test
    public void testBuildSingleMessage() {
        List<LogMessage> messages = new ArrayList<>();
        LogMessage message = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "single message"
        );
        messages.add(message);
        
        MessageTree result = LogAnalysis.build(messages);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message, node.message());
        assertTrue(node.left() instanceof MessageTree.Leaf);
        assertTrue(node.right() instanceof MessageTree.Leaf);
    }
    
    @Test
    public void testBuildMultipleMessages() {
        List<LogMessage> messages = new ArrayList<>();
        LogMessage message1 = new LogMessage.LogMessageData(
            new MessageType.Info(), 20, "second"
        );
        LogMessage message2 = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "first"
        );
        LogMessage message3 = new LogMessage.LogMessageData(
            new MessageType.Info(), 30, "third"
        );
        
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        
        MessageTree result = LogAnalysis.build(messages);
        
        // Verify the tree structure by checking in-order traversal
        List<LogMessage> inOrder = LogAnalysis.inOrder(result);
        assertEquals(3, inOrder.size());
        assertEquals(message2, inOrder.get(0)); // timestamp 10
        assertEquals(message1, inOrder.get(1)); // timestamp 20
        assertEquals(message3, inOrder.get(2)); // timestamp 30
    }
    
    @Test
    public void testBuildWithUnknownMessages() {
        List<LogMessage> messages = new ArrayList<>();
        LogMessage validMessage = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "valid"
        );
        LogMessage unknownMessage = new LogMessage.Unknown("unknown");
        
        messages.add(validMessage);
        messages.add(unknownMessage);
        
        MessageTree result = LogAnalysis.build(messages);
        
        // Only valid messages should be in the tree
        List<LogMessage> inOrder = LogAnalysis.inOrder(result);
        assertEquals(1, inOrder.size());
        assertEquals(validMessage, inOrder.get(0));
    }
    
    @Test
    public void testBuildWithDuplicateTimestamps() {
        List<LogMessage> messages = new ArrayList<>();
        LogMessage message1 = new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "first"
        );
        LogMessage message2 = new LogMessage.LogMessageData(
            new MessageType.Warning(), 10, "second"
        );
        
        messages.add(message1);
        messages.add(message2);
        
        MessageTree result = LogAnalysis.build(messages);
        
        // Both messages should be in the tree
        List<LogMessage> inOrder = LogAnalysis.inOrder(result);
        assertEquals(2, inOrder.size());
        assertEquals(message1, inOrder.get(0));
        assertEquals(message2, inOrder.get(1));
    }
}