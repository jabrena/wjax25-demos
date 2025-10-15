package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise2Test {

    @Test
    public void testInsert_EmptyTree() {
        MessageTree tree = new MessageTree.Leaf();
        LogMessage message = new LogMessage.InfoMessage(5, "Test message");
        
        MessageTree result = Exercise2.insert(message, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message, node.getMessage());
        assertTrue(node.getLeft() instanceof MessageTree.Leaf);
        assertTrue(node.getRight() instanceof MessageTree.Leaf);
    }

    @Test
    public void testInsert_SingleNode() {
        LogMessage message1 = new LogMessage.InfoMessage(5, "First message");
        LogMessage message2 = new LogMessage.InfoMessage(3, "Second message");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), 
            message1, 
            new MessageTree.Leaf()
        );
        
        MessageTree result = Exercise2.insert(message2, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message1, node.getMessage());
        assertTrue(node.getLeft() instanceof MessageTree.Node);
        assertTrue(node.getRight() instanceof MessageTree.Leaf);
        
        MessageTree.Node leftNode = (MessageTree.Node) node.getLeft();
        assertEquals(message2, leftNode.getMessage());
    }

    @Test
    public void testInsert_RightSide() {
        LogMessage message1 = new LogMessage.InfoMessage(3, "First message");
        LogMessage message2 = new LogMessage.InfoMessage(7, "Second message");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), 
            message1, 
            new MessageTree.Leaf()
        );
        
        MessageTree result = Exercise2.insert(message2, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message1, node.getMessage());
        assertTrue(node.getLeft() instanceof MessageTree.Leaf);
        assertTrue(node.getRight() instanceof MessageTree.Node);
        
        MessageTree.Node rightNode = (MessageTree.Node) node.getRight();
        assertEquals(message2, rightNode.getMessage());
    }

    @Test
    public void testInsert_ErrorMessage() {
        LogMessage infoMessage = new LogMessage.InfoMessage(5, "Info message");
        LogMessage errorMessage = new LogMessage.ErrorMessage(3, 100, "Error message");
        
        MessageTree tree = new MessageTree.Node(
            new MessageTree.Leaf(), 
            infoMessage, 
            new MessageTree.Leaf()
        );
        
        MessageTree result = Exercise2.insert(errorMessage, tree);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(infoMessage, node.getMessage());
        assertTrue(node.getLeft() instanceof MessageTree.Node);
        assertTrue(node.getRight() instanceof MessageTree.Leaf);
        
        MessageTree.Node leftNode = (MessageTree.Node) node.getLeft();
        assertEquals(errorMessage, leftNode.getMessage());
    }

    @Test
    public void testBuildTree_EmptyList() {
        List<LogMessage> messages = Arrays.asList();
        MessageTree result = Exercise2.buildTree(messages);
        
        assertTrue(result instanceof MessageTree.Leaf);
    }

    @Test
    public void testBuildTree_SingleMessage() {
        LogMessage message = new LogMessage.InfoMessage(5, "Single message");
        List<LogMessage> messages = Arrays.asList(message);
        
        MessageTree result = Exercise2.buildTree(messages);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node node = (MessageTree.Node) result;
        assertEquals(message, node.getMessage());
        assertTrue(node.getLeft() instanceof MessageTree.Leaf);
        assertTrue(node.getRight() instanceof MessageTree.Leaf);
    }

    @Test
    public void testBuildTree_MultipleMessages() {
        LogMessage message1 = new LogMessage.InfoMessage(5, "Message 1");
        LogMessage message2 = new LogMessage.InfoMessage(3, "Message 2");
        LogMessage message3 = new LogMessage.InfoMessage(7, "Message 3");
        List<LogMessage> messages = Arrays.asList(message1, message2, message3);
        
        MessageTree result = Exercise2.buildTree(messages);
        
        assertTrue(result instanceof MessageTree.Node);
        MessageTree.Node root = (MessageTree.Node) result;
        assertEquals(message1, root.getMessage());
        
        // Check that the tree is properly structured
        assertTrue(root.getLeft() instanceof MessageTree.Node);
        assertTrue(root.getRight() instanceof MessageTree.Node);
        
        MessageTree.Node leftNode = (MessageTree.Node) root.getLeft();
        MessageTree.Node rightNode = (MessageTree.Node) root.getRight();
        
        assertEquals(message2, leftNode.getMessage());
        assertEquals(message3, rightNode.getMessage());
    }
}