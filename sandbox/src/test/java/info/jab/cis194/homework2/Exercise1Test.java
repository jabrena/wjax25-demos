package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Exercise1Test {

    @Test
    public void testParseMessage_InfoMessage() {
        String logLine = "I 6 Completed armadillo processing";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.InfoMessage);
        LogMessage.InfoMessage infoMsg = (LogMessage.InfoMessage) result;
        assertEquals(6, infoMsg.getTimestamp());
        assertEquals("Completed armadillo processing", infoMsg.getMessage());
    }

    @Test
    public void testParseMessage_WarningMessage() {
        String logLine = "W 5 Flange is due for a check-up";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.WarningMessage);
        LogMessage.WarningMessage warningMsg = (LogMessage.WarningMessage) result;
        assertEquals(5, warningMsg.getTimestamp());
        assertEquals("Flange is due for a check-up", warningMsg.getMessage());
    }

    @Test
    public void testParseMessage_ErrorMessage() {
        String logLine = "E 70 3 Way too many pickles";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.ErrorMessage);
        LogMessage.ErrorMessage errorMsg = (LogMessage.ErrorMessage) result;
        assertEquals(70, errorMsg.getTimestamp());
        assertEquals(3, errorMsg.getErrorCode());
        assertEquals("Way too many pickles", errorMsg.getMessage());
    }

    @Test
    public void testParseMessage_UnknownMessage() {
        String logLine = "This is not a valid log message";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.UnknownMessage);
        LogMessage.UnknownMessage unknownMsg = (LogMessage.UnknownMessage) result;
        assertEquals("This is not a valid log message", unknownMsg.getMessage());
    }

    @Test
    public void testParseMessage_EmptyString() {
        String logLine = "";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.UnknownMessage);
    }

    @Test
    public void testParseMessage_InvalidFormat() {
        String logLine = "X 5 Invalid format";
        LogMessage result = Exercise1.parseMessage(logLine);
        
        assertNotNull(result);
        assertTrue(result instanceof LogMessage.UnknownMessage);
    }
}