package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 3: build function
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
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 10, "single message")
        );
        
        MessageTree result = LogAnalysis.build(messages);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(messages.get(0), node.message());
        assertTrue(node.left() instanceof MessageTree.Leaf);
        assertTrue(node.right() instanceof MessageTree.Leaf);
    }
    
    @Test
    public void testBuildMultipleMessages() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 20, "second"),
            new LogMessage.LogMessageRecord(new MessageType.Warning(), 10, "first"),
            new LogMessage.LogMessageRecord(new MessageType.Error(5), 30, "third")
        );
        
        MessageTree result = LogAnalysis.build(messages);
        
        // The tree should contain all messages
        List<LogMessage> inOrderResult = LogAnalysis.inOrder(result);
        assertEquals(3, inOrderResult.size());
        assertTrue(inOrderResult.contains(messages.get(0)));
        assertTrue(inOrderResult.contains(messages.get(1)));
        assertTrue(inOrderResult.contains(messages.get(2)));
    }
    
    @Test
    public void testBuildWithUnknownMessages() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 10, "valid"),
            new LogMessage.Unknown("invalid message"),
            new LogMessage.LogMessageRecord(new MessageType.Warning(), 20, "also valid")
        );
        
        MessageTree result = LogAnalysis.build(messages);
        
        // Only valid messages should be in the tree
        List<LogMessage> inOrderResult = LogAnalysis.inOrder(result);
        assertEquals(2, inOrderResult.size());
        assertTrue(inOrderResult.contains(messages.get(0)));
        assertTrue(inOrderResult.contains(messages.get(2)));
        assertFalse(inOrderResult.contains(messages.get(1)));
    }
    
    @Test
    public void testBuildSortedOrder() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 30, "third"),
            new LogMessage.LogMessageRecord(new MessageType.Warning(), 10, "first"),
            new LogMessage.LogMessageRecord(new MessageType.Error(5), 20, "second")
        );
        
        MessageTree result = LogAnalysis.build(messages);
        
        // The in-order traversal should be sorted by timestamp
        List<LogMessage> inOrderResult = LogAnalysis.inOrder(result);
        assertEquals(3, inOrderResult.size());
        
        // Check that timestamps are in ascending order
        for (int i = 0; i < inOrderResult.size() - 1; i++) {
            LogMessage current = inOrderResult.get(i);
            LogMessage next = inOrderResult.get(i + 1);
            
            if (current instanceof LogMessage.LogMessageRecord currentLog &&
                next instanceof LogMessage.LogMessageRecord nextLog) {
                assertTrue(currentLog.timestamp() <= nextLog.timestamp());
            }
        }
    }
}