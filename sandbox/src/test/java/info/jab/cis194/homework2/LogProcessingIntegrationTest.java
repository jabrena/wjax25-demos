package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Integration test that demonstrates the complete log processing pipeline
 * using all exercises together.
 */
public class LogProcessingIntegrationTest {

    @Test
    public void testCompleteLogProcessingPipeline() {
        // Sample log data similar to the course materials
        String[] logLines = {
            "I 6 Completed armadillo processing",
            "I 1 Nothing to report",
            "I 4 Everything normal",
            "I 11 Initiating self-destruct sequence",
            "E 70 3 Way too many pickles",
            "E 65 8 Bad pickle-flange interaction detected",
            "W 5 Flange is due for a check-up",
            "I 7 Out for lunch, back in two time steps",
            "E 20 2 Too many pickles",
            "I 9 Back from lunch",
            "E 99 10 Flange failed!"
        };
        
        // Exercise 1: Parse all log messages
        List<LogMessage> messages = Arrays.stream(logLines)
            .map(Exercise1::parseMessage)
            .toList();
        
        assertEquals(11, messages.size());
        
        // Verify we have the right types of messages
        long infoCount = messages.stream()
            .filter(m -> m instanceof LogMessage.InfoMessage)
            .count();
        long warningCount = messages.stream()
            .filter(m -> m instanceof LogMessage.WarningMessage)
            .count();
        long errorCount = messages.stream()
            .filter(m -> m instanceof LogMessage.ErrorMessage)
            .count();
        
        assertEquals(6, infoCount);
        assertEquals(1, warningCount);
        assertEquals(4, errorCount);
        
        // Exercise 2: Build binary search tree
        MessageTree tree = Exercise2.buildTree(messages);
        assertNotNull(tree);
        assertTrue(tree instanceof MessageTree.Node);
        
        // Exercise 3: Get messages in chronological order
        List<LogMessage> chronologicalMessages = Exercise3.inOrder(tree);
        assertEquals(11, chronologicalMessages.size());
        
        // Verify chronological order (by timestamp)
        for (int i = 1; i < chronologicalMessages.size(); i++) {
            int prevTimestamp = getTimestamp(chronologicalMessages.get(i - 1));
            int currTimestamp = getTimestamp(chronologicalMessages.get(i));
            assertTrue(prevTimestamp <= currTimestamp, 
                "Messages should be in chronological order");
        }
        
        // Exercise 4: Extract error messages
        List<String> errorMessages = Exercise4.whatWentWrong(chronologicalMessages);
        assertEquals(4, errorMessages.size());
        
        // Verify specific error messages
        assertTrue(errorMessages.contains("Too many pickles"));
        assertTrue(errorMessages.contains("Bad pickle-flange interaction detected"));
        assertTrue(errorMessages.contains("Way too many pickles"));
        assertTrue(errorMessages.contains("Flange failed!"));
    }
    
    @Test
    public void testLogProcessingWithInvalidMessages() {
        String[] logLines = {
            "I 1 Valid info message",
            "Invalid log format",
            "W 2 Valid warning message",
            "E 3 100 Valid error message",
            "X 4 Invalid message type",
            "I 5 Another valid message"
        };
        
        // Parse all messages
        List<LogMessage> messages = Arrays.stream(logLines)
            .map(Exercise1::parseMessage)
            .toList();
        
        assertEquals(6, messages.size());
        
        // Count message types
        long validCount = messages.stream()
            .filter(m -> !(m instanceof LogMessage.UnknownMessage))
            .count();
        long unknownCount = messages.stream()
            .filter(m -> m instanceof LogMessage.UnknownMessage)
            .count();
        
        assertEquals(4, validCount);
        assertEquals(2, unknownCount);
        
        // Build tree and process
        MessageTree tree = Exercise2.buildTree(messages);
        List<LogMessage> chronologicalMessages = Exercise3.inOrder(tree);
        List<String> errorMessages = Exercise4.whatWentWrong(chronologicalMessages);
        
        assertEquals(1, errorMessages.size());
        assertEquals("Valid error message", errorMessages.get(0));
    }
    
    private int getTimestamp(LogMessage message) {
        if (message instanceof LogMessage.InfoMessage) {
            return ((LogMessage.InfoMessage) message).getTimestamp();
        } else if (message instanceof LogMessage.WarningMessage) {
            return ((LogMessage.WarningMessage) message).getTimestamp();
        } else if (message instanceof LogMessage.ErrorMessage) {
            return ((LogMessage.ErrorMessage) message).getTimestamp();
        } else {
            return Integer.MAX_VALUE;
        }
    }
}