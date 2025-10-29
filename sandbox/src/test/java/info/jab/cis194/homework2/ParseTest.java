package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Tests for the parse function
 */
public class ParseTest {
    
    @Test
    public void testParseEmptyString() {
        List<LogMessage> result = LogAnalysis.parse("");
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testParseNullString() {
        List<LogMessage> result = LogAnalysis.parse(null);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testParseSingleLine() {
        String logContent = "I 29 la la la";
        List<LogMessage> result = LogAnalysis.parse(logContent);
        
        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) result.get(0);
        assertTrue(messageData.messageType() instanceof MessageType.Info);
        assertEquals(29, messageData.timeStamp());
        assertEquals("la la la", messageData.content());
    }
    
    @Test
    public void testParseMultipleLines() {
        String logContent = "I 29 la la la\nW 5 Flange is due for a check-up\nE 2 562 help help";
        List<LogMessage> result = LogAnalysis.parse(logContent);
        
        assertEquals(3, result.size());
        
        // First message (Info)
        assertTrue(result.get(0) instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData message1 = (LogMessage.LogMessageData) result.get(0);
        assertTrue(message1.messageType() instanceof MessageType.Info);
        assertEquals(29, message1.timeStamp());
        assertEquals("la la la", message1.content());
        
        // Second message (Warning)
        assertTrue(result.get(1) instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData message2 = (LogMessage.LogMessageData) result.get(1);
        assertTrue(message2.messageType() instanceof MessageType.Warning);
        assertEquals(5, message2.timeStamp());
        assertEquals("Flange is due for a check-up", message2.content());
        
        // Third message (Error)
        assertTrue(result.get(2) instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData message3 = (LogMessage.LogMessageData) result.get(2);
        assertTrue(message3.messageType() instanceof MessageType.Error);
        MessageType.Error error = (MessageType.Error) message3.messageType();
        assertEquals(2, error.severity());
        assertEquals(562, message3.timeStamp());
        assertEquals("help help", message3.content());
    }
    
    @Test
    public void testParseWithEmptyLines() {
        String logContent = "I 29 la la la\n\nW 5 Flange is due for a check-up\n\n";
        List<LogMessage> result = LogAnalysis.parse(logContent);
        
        assertEquals(3, result.size());
        
        // First message (Info)
        assertTrue(result.get(0) instanceof LogMessage.LogMessageData);
        
        // Second message (Unknown - empty line)
        assertTrue(result.get(1) instanceof LogMessage.Unknown);
        assertEquals("", ((LogMessage.Unknown) result.get(1)).content());
        
        // Third message (Warning)
        assertTrue(result.get(2) instanceof LogMessage.LogMessageData);
    }
    
    @Test
    public void testParseWithWindowsLineEndings() {
        String logContent = "I 29 la la la\r\nW 5 Flange is due for a check-up\r\nE 2 562 help help";
        List<LogMessage> result = LogAnalysis.parse(logContent);
        
        assertEquals(3, result.size());
        assertTrue(result.get(0) instanceof LogMessage.LogMessageData);
        assertTrue(result.get(1) instanceof LogMessage.LogMessageData);
        assertTrue(result.get(2) instanceof LogMessage.LogMessageData);
    }
    
    @Test
    public void testParseSampleLog() {
        String logContent = "I 6 Completed armadillo processing\n" +
                           "I 1 Nothing to report\n" +
                           "E 99 10 Flange failed!\n" +
                           "I 4 Everything normal\n" +
                           "I 11 Initiating self-destruct sequence\n" +
                           "E 70 3 Way too many pickles\n" +
                           "E 65 8 Bad pickle-flange interaction detected\n" +
                           "W 5 Flange is due for a check-up\n" +
                           "I 7 Out for lunch, back in two time steps\n" +
                           "E 20 2 Too many pickles\n" +
                           "I 9 Back from lunch";
        
        List<LogMessage> result = LogAnalysis.parse(logContent);
        
        assertEquals(11, result.size());
        
        // Check that all messages are parsed correctly
        int infoCount = 0;
        int warningCount = 0;
        int errorCount = 0;
        
        for (LogMessage message : result) {
            if (message instanceof LogMessage.LogMessageData messageData) {
                if (messageData.messageType() instanceof MessageType.Info) {
                    infoCount++;
                } else if (messageData.messageType() instanceof MessageType.Warning) {
                    warningCount++;
                } else if (messageData.messageType() instanceof MessageType.Error) {
                    errorCount++;
                }
            }
        }
        
        assertEquals(6, infoCount);
        assertEquals(1, warningCount);
        assertEquals(4, errorCount);
    }
}