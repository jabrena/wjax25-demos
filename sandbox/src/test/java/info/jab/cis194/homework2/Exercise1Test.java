package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Exercise 1: parseMessage function
 */
public class Exercise1Test {
    
    @Test
    public void testParseInfoMessage() {
        LogMessage result = LogAnalysis.parseMessage("I 29 la la la");
        
        assertTrue(result instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) result;
        
        assertTrue(messageData.messageType() instanceof MessageType.Info);
        assertEquals(29, messageData.timeStamp());
        assertEquals("la la la", messageData.content());
    }
    
    @Test
    public void testParseWarningMessage() {
        LogMessage result = LogAnalysis.parseMessage("W 5 Flange is due for a check-up");
        
        assertTrue(result instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) result;
        
        assertTrue(messageData.messageType() instanceof MessageType.Warning);
        assertEquals(5, messageData.timeStamp());
        assertEquals("Flange is due for a check-up", messageData.content());
    }
    
    @Test
    public void testParseErrorMessage() {
        LogMessage result = LogAnalysis.parseMessage("E 2 562 help help");
        
        assertTrue(result instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) result;
        
        assertTrue(messageData.messageType() instanceof MessageType.Error);
        MessageType.Error error = (MessageType.Error) messageData.messageType();
        assertEquals(2, error.severity());
        assertEquals(562, messageData.timeStamp());
        assertEquals("help help", messageData.content());
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
        LogMessage.Unknown unknown = (LogMessage.Unknown) result;
        assertEquals("", unknown.content());
    }
    
    @Test
    public void testParseNullMessage() {
        LogMessage result = LogAnalysis.parseMessage(null);
        
        assertTrue(result instanceof LogMessage.Unknown);
        LogMessage.Unknown unknown = (LogMessage.Unknown) result;
        assertEquals(null, unknown.content());
    }
    
    @Test
    public void testParseWithWhitespace() {
        LogMessage result = LogAnalysis.parseMessage("  I 29 la la la  ");
        
        assertTrue(result instanceof LogMessage.LogMessageData);
        LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) result;
        
        assertTrue(messageData.messageType() instanceof MessageType.Info);
        assertEquals(29, messageData.timeStamp());
        assertEquals("la la la", messageData.content());
    }
}