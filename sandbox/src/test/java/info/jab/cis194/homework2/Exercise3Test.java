package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise3Test {

    @Test
    public void testInOrder_EmptyTree() {
        MessageTree tree = new MessageTree.Leaf();
        List<LogMessage> result = Exercise3.inOrder(tree);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testInOrder_SingleNode() {
        LogMessage message = new LogMessage.InfoMessage(5, "Single message");
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(),
            message,
            new MessageTree.Leaf()
        );
        
        List<LogMessage> result = Exercise3.inOrder(tree);
        
        assertEquals(1, result.size());
        assertEquals(message, result.get(0));
    }

    @Test
    public void testInOrder_MultipleNodes() {
        LogMessage message1 = new LogMessage.InfoMessage(3, "Message 1");
        LogMessage message2 = new LogMessage.InfoMessage(5, "Message 2");
        LogMessage message3 = new LogMessage.InfoMessage(7, "Message 3");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Node(
                new MessageTree.Leaf(),
                message1,
                new MessageTree.Leaf()
            ),
            message2,
            new MessageTree.Node(
                new MessageTree.Leaf(),
                message3,
                new MessageTree.Leaf()
            )
        );
        
        List<LogMessage> result = Exercise3.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(message1, result.get(0));
        assertEquals(message2, result.get(1));
        assertEquals(message3, result.get(2));
    }

    @Test
    public void testInOrder_UnbalancedTree() {
        LogMessage message1 = new LogMessage.InfoMessage(1, "Message 1");
        LogMessage message2 = new LogMessage.InfoMessage(2, "Message 2");
        LogMessage message3 = new LogMessage.InfoMessage(3, "Message 3");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(),
            message1,
            new MessageTree.Node(
                new MessageTree.Leaf(),
                message2,
                new MessageTree.Node(
                    new MessageTree.Leaf(),
                    message3,
                    new MessageTree.Leaf()
                )
            )
        );
        
        List<LogMessage> result = Exercise3.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(message1, result.get(0));
        assertEquals(message2, result.get(1));
        assertEquals(message3, result.get(2));
    }

    @Test
    public void testInOrder_MixedMessageTypes() {
        LogMessage infoMessage = new LogMessage.InfoMessage(1, "Info message");
        LogMessage warningMessage = new LogMessage.WarningMessage(2, "Warning message");
        LogMessage errorMessage = new LogMessage.ErrorMessage(3, 100, "Error message");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Node(
                new MessageTree.Leaf(),
                infoMessage,
                new MessageTree.Leaf()
            ),
            warningMessage,
            new MessageTree.Node(
                new MessageTree.Leaf(),
                errorMessage,
                new MessageTree.Leaf()
            )
        );
        
        List<LogMessage> result = Exercise3.inOrder(tree);
        
        assertEquals(3, result.size());
        assertEquals(infoMessage, result.get(0));
        assertEquals(warningMessage, result.get(1));
        assertEquals(errorMessage, result.get(2));
    }
}