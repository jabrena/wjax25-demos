package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

/**
 * Test class for Log functionality.
 * Implements TDD approach for Homework 2 exercises.
 */
public class LogTest {
    
    @Test
    public void testParseMessage_InfoMessage() {
        // Exercise 1: Test parsing of INFO message
        LogMessage result = Log.parseMessage("I 6 Completed armadillo processing");
        
        assertFalse(result.isUnknown());
        assertEquals(MessageType.INFO, result.getMessageType());
        assertEquals(6, result.getTimestamp());
        assertEquals("Completed armadillo processing", result.getMessage());
    }
    
    @Test
    public void testParseMessage_WarningMessage() {
        // Exercise 1: Test parsing of WARNING message
        LogMessage result = Log.parseMessage("W 5 Flange is due for a check-up");
        
        assertFalse(result.isUnknown());
        assertEquals(MessageType.WARNING, result.getMessageType());
        assertEquals(5, result.getTimestamp());
        assertEquals("Flange is due for a check-up", result.getMessage());
    }
    
    @Test
    public void testParseMessage_ErrorMessage() {
        // Exercise 1: Test parsing of ERROR message
        LogMessage result = Log.parseMessage("E 70 3 Way too many pickles");
        
        assertFalse(result.isUnknown());
        assertEquals(MessageType.ERROR, result.getMessageType());
        assertEquals(70, result.getTimestamp());
        assertEquals("3 Way too many pickles", result.getMessage());
    }
    
    @Test
    public void testParseMessage_UnknownMessage() {
        // Exercise 1: Test parsing of unknown/invalid message
        LogMessage result = Log.parseMessage("Invalid log message");
        
        assertTrue(result.isUnknown());
        assertEquals("Invalid log message", result.getMessage());
    }
    
    @Test
    public void testParseMessage_EmptyMessage() {
        // Exercise 1: Test parsing of empty message
        LogMessage result = Log.parseMessage("");
        
        assertTrue(result.isUnknown());
        assertEquals("Empty line", result.getMessage());
    }
    
    @Test
    public void testParseMessage_NullMessage() {
        // Exercise 1: Test parsing of null message
        LogMessage result = Log.parseMessage(null);
        
        assertTrue(result.isUnknown());
        assertEquals("Empty line", result.getMessage());
    }
    
    @Test
    public void testParse_MultipleMessages() {
        // Exercise 2: Test parsing multiple log messages
        String logData = "I 6 Completed armadillo processing\n" +
                        "W 5 Flange is due for a check-up\n" +
                        "E 70 3 Way too many pickles";
        
        List<LogMessage> result = Log.parse(logData);
        
        assertEquals(3, result.size());
        
        // First message
        assertEquals(MessageType.INFO, result.get(0).getMessageType());
        assertEquals(6, result.get(0).getTimestamp());
        assertEquals("Completed armadillo processing", result.get(0).getMessage());
        
        // Second message
        assertEquals(MessageType.WARNING, result.get(1).getMessageType());
        assertEquals(5, result.get(1).getTimestamp());
        assertEquals("Flange is due for a check-up", result.get(1).getMessage());
        
        // Third message
        assertEquals(MessageType.ERROR, result.get(2).getMessageType());
        assertEquals(70, result.get(2).getTimestamp());
        assertEquals("3 Way too many pickles", result.get(2).getMessage());
    }
    
    @Test
    public void testInsert_IntoEmptyTree() {
        // Exercise 3: Test inserting into empty tree
        LogMessage message = new LogMessage(MessageType.INFO, 5, "Test message");
        MessageTree tree = new MessageTree();
        
        MessageTree result = Log.insert(message, tree);
        
        assertFalse(result.isLeaf());
        assertEquals(message, result.getMessage());
        assertTrue(result.getLeft().isLeaf());
        assertTrue(result.getRight().isLeaf());
    }
    
    @Test
    public void testInsert_IntoNonEmptyTree() {
        // Exercise 3: Test inserting into non-empty tree
        LogMessage message1 = new LogMessage(MessageType.INFO, 5, "First message");
        LogMessage message2 = new LogMessage(MessageType.WARNING, 3, "Second message");
        LogMessage message3 = new LogMessage(MessageType.ERROR, 7, "Third message");
        
        MessageTree tree = new MessageTree();
        tree = Log.insert(message1, tree);
        tree = Log.insert(message2, tree);
        tree = Log.insert(message3, tree);
        
        // Root should be message1 (timestamp 5)
        assertEquals(message1, tree.getMessage());
        
        // Left child should be message2 (timestamp 3)
        assertEquals(message2, tree.getLeft().getMessage());
        
        // Right child should be message3 (timestamp 7)
        assertEquals(message3, tree.getRight().getMessage());
    }
    
    @Test
    public void testBuild_FromMessageList() {
        // Exercise 4: Test building tree from message list
        List<LogMessage> messages = Arrays.asList(
            new LogMessage(MessageType.INFO, 5, "First message"),
            new LogMessage(MessageType.WARNING, 3, "Second message"),
            new LogMessage(MessageType.ERROR, 7, "Third message")
        );
        
        MessageTree tree = Log.build(messages);
        
        assertFalse(tree.isLeaf());
        // The root should be the first message (timestamp 5)
        assertEquals(messages.get(0), tree.getMessage());
    }
    
    @Test
    public void testInOrder_EmptyTree() {
        // Exercise 5: Test in-order traversal of empty tree
        MessageTree tree = new MessageTree();
        List<String> result = Log.inOrder(tree);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testInOrder_WithErrorMessages() {
        // Exercise 5: Test in-order traversal with error messages
        List<LogMessage> messages = Arrays.asList(
            new LogMessage(MessageType.INFO, 5, "Info message"),
            new LogMessage(MessageType.ERROR, 3, "First error"),
            new LogMessage(MessageType.WARNING, 7, "Warning message"),
            new LogMessage(MessageType.ERROR, 9, "Second error")
        );
        
        MessageTree tree = Log.build(messages);
        List<String> result = Log.inOrder(tree);
        
        // Should contain only error messages in timestamp order
        assertEquals(2, result.size());
        assertTrue(result.contains("First error"));
        assertTrue(result.contains("Second error"));
    }
    
    @Test
    public void testWhatWentWrong_CompleteWorkflow() {
        // Exercise 6: Test complete workflow
        String logData = "I 6 Completed armadillo processing\n" +
                        "E 70 3 Way too many pickles\n" +
                        "W 5 Flange is due for a check-up\n" +
                        "E 20 2 Too many pickles\n" +
                        "I 7 Out for lunch, back in two time steps";
        
        List<String> result = Log.whatWentWrong(logData);
        
        // Should contain error messages in timestamp order
        assertEquals(2, result.size());
        assertTrue(result.contains("2 Too many pickles"));
        assertTrue(result.contains("3 Way too many pickles"));
    }
    
    @Test
    public void testWhatWentWrong_NoErrors() {
        // Exercise 6: Test with no error messages
        String logData = "I 6 Completed armadillo processing\n" +
                        "W 5 Flange is due for a check-up\n" +
                        "I 7 Out for lunch, back in two time steps";
        
        List<String> result = Log.whatWentWrong(logData);
        
        assertTrue(result.isEmpty());
    }
}