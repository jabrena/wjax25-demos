package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 1: parseMessage function
 */
public class Exercise1Test {
    
    @Test
    public void testParseInfoMessage() {
        LogMessage result = LogAnalysis.parseMessage("I 29 la la la");
        
        assertTrue(result instanceof LogMessage.LogMessageRecord);
        LogMessage.LogMessageRecord logMsg = (LogMessage.LogMessageRecord) result;
        
        assertTrue(logMsg.messageType() instanceof MessageType.Info);
        assertEquals(29, logMsg.timestamp());
        assertEquals("la la la", logMsg.content());
    }
    
    @Test
    public void testParseErrorMessage() {
        LogMessage result = LogAnalysis.parseMessage("E 2 562 help help");
        
        assertTrue(result instanceof LogMessage.LogMessageRecord);
        LogMessage.LogMessageRecord logMsg = (LogMessage.LogMessageRecord) result;
        
        assertTrue(logMsg.messageType() instanceof MessageType.Error);
        MessageType.Error error = (MessageType.Error) logMsg.messageType();
        assertEquals(2, error.severity());
        assertEquals(562, logMsg.timestamp());
        assertEquals("help help", logMsg.content());
    }
    
    @Test
    public void testParseWarningMessage() {
        LogMessage result = LogAnalysis.parseMessage("W 5 Flange is due for a check-up");
        
        assertTrue(result instanceof LogMessage.LogMessageRecord);
        LogMessage.LogMessageRecord logMsg = (LogMessage.LogMessageRecord) result;
        
        assertTrue(logMsg.messageType() instanceof MessageType.Warning);
        assertEquals(5, logMsg.timestamp());
        assertEquals("Flange is due for a check-up", logMsg.content());
    }
    
    @Test
    public void testParseUnknownMessage() {
        LogMessage result = LogAnalysis.parseMessage("This is not in the right format");
        
        assertTrue(result instanceof LogMessage.Unknown);
        LogMessage.Unknown unknown = (LogMessage.Unknown) result;
        assertEquals("This is not in the right format", unknown.content());
    }
    
    @Test
    public void testParseEmptyMessage() {
        LogMessage result = LogAnalysis.parseMessage("");
        
        assertTrue(result instanceof LogMessage.Unknown);
    }
    
    @Test
    public void testParseNullMessage() {
        LogMessage result = LogAnalysis.parseMessage(null);
        
        assertTrue(result instanceof LogMessage.Unknown);
    }
    
    @Test
    public void testParseIncompleteErrorMessage() {
        LogMessage result = LogAnalysis.parseMessage("E 2");
        
        assertTrue(result instanceof LogMessage.Unknown);
    }
    
    @Test
    public void testParseInvalidTimestamp() {
        LogMessage result = LogAnalysis.parseMessage("I abc invalid timestamp");
        
        assertTrue(result instanceof LogMessage.Unknown);
    }
}