package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test using the actual log files from the homework
 */
public class IntegrationTest {
    
    @Test
    public void testParseSampleLog() throws IOException {
        String sampleLogContent = """
            I 6 Completed armadillo processing
            I 1 Nothing to report
            I 4 Everything normal
            I 11 Initiating self-destruct sequence
            E 70 3 Way too many pickles
            E 65 8 Bad pickle-flange interaction detected
            W 5 Flange is due for a check-up
            I 7 Out for lunch, back in two time steps
            E 20 2 Too many pickles
            I 9 Back from lunch
            E 99 10 Flange failed!
            """;
        
        List<LogMessage> messages = LogAnalysis.parse(sampleLogContent);
        
        assertEquals(11, messages.size());
        
        // Check that we have the right types of messages
        long infoCount = messages.stream()
            .filter(msg -> msg instanceof LogMessage.LogMessageRecord logMsg && 
                          logMsg.messageType() instanceof MessageType.Info)
            .count();
        assertEquals(6, infoCount);
        
        long warningCount = messages.stream()
            .filter(msg -> msg instanceof LogMessage.LogMessageRecord logMsg && 
                          logMsg.messageType() instanceof MessageType.Warning)
            .count();
        assertEquals(1, warningCount);
        
        long errorCount = messages.stream()
            .filter(msg -> msg instanceof LogMessage.LogMessageRecord logMsg && 
                          logMsg.messageType() instanceof MessageType.Error)
            .count();
        assertEquals(4, errorCount);
    }
    
    @Test
    public void testWhatWentWrongSampleLog() throws IOException {
        String sampleLogContent = """
            I 6 Completed armadillo processing
            I 1 Nothing to report
            I 4 Everything normal
            I 11 Initiating self-destruct sequence
            E 70 3 Way too many pickles
            E 65 8 Bad pickle-flange interaction detected
            W 5 Flange is due for a check-up
            I 7 Out for lunch, back in two time steps
            E 20 2 Too many pickles
            I 9 Back from lunch
            E 99 10 Flange failed!
            """;
        
        List<LogMessage> messages = LogAnalysis.parse(sampleLogContent);
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        // According to the homework, should return:
        // ["Way too many pickles", "Bad pickle-flange interaction detected", "Flange failed!"]
        assertEquals(3, result.size());
        assertEquals("Way too many pickles", result.get(0));
        assertEquals("Bad pickle-flange interaction detected", result.get(1));
        assertEquals("Flange failed!", result.get(2));
    }
    
    @Test
    public void testParseAndSortSampleLog() throws IOException {
        String sampleLogContent = """
            I 6 Completed armadillo processing
            I 1 Nothing to report
            I 4 Everything normal
            I 11 Initiating self-destruct sequence
            E 70 3 Way too many pickles
            E 65 8 Bad pickle-flange interaction detected
            W 5 Flange is due for a check-up
            I 7 Out for lunch, back in two time steps
            E 20 2 Too many pickles
            I 9 Back from lunch
            E 99 10 Flange failed!
            """;
        
        List<LogMessage> messages = LogAnalysis.parse(sampleLogContent);
        MessageTree tree = LogAnalysis.build(messages);
        List<LogMessage> sortedMessages = LogAnalysis.inOrder(tree);
        
        // Check that messages are sorted by timestamp
        for (int i = 0; i < sortedMessages.size() - 1; i++) {
            LogMessage current = sortedMessages.get(i);
            LogMessage next = sortedMessages.get(i + 1);
            
            if (current instanceof LogMessage.LogMessageRecord currentLog &&
                next instanceof LogMessage.LogMessageRecord nextLog) {
                assertTrue(currentLog.timestamp() <= nextLog.timestamp());
            }
        }
        
        // Check that we have the expected number of messages (excluding Unknown)
        long validMessageCount = sortedMessages.stream()
            .filter(msg -> msg instanceof LogMessage.LogMessageRecord)
            .count();
        assertEquals(11, validMessageCount);
    }
}