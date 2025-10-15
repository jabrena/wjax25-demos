package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Exercise 5: whatWentWrong function
 */
public class Exercise5Test {
    
    @Test
    public void testWhatWentWrongEmptyList() {
        List<LogMessage> messages = List.of();
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongNoErrors() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 10, "info message"),
            new LogMessage.LogMessageRecord(new MessageType.Warning(), 20, "warning message")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongLowSeverityErrors() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Error(10), 10, "low severity error"),
            new LogMessage.LogMessageRecord(new MessageType.Error(49), 20, "another low severity error")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongHighSeverityErrors() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Error(50), 10, "high severity error"),
            new LogMessage.LogMessageRecord(new MessageType.Error(75), 20, "another high severity error"),
            new LogMessage.LogMessageRecord(new MessageType.Error(100), 30, "critical error")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(3, result.size());
        assertTrue(result.contains("high severity error"));
        assertTrue(result.contains("another high severity error"));
        assertTrue(result.contains("critical error"));
    }
    
    @Test
    public void testWhatWentWrongMixedSeverity() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Error(10), 10, "low severity"),
            new LogMessage.LogMessageRecord(new MessageType.Error(50), 20, "medium severity"),
            new LogMessage.LogMessageRecord(new MessageType.Error(75), 30, "high severity"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 40, "info message")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(2, result.size());
        assertTrue(result.contains("medium severity"));
        assertTrue(result.contains("high severity"));
        assertFalse(result.contains("low severity"));
        assertFalse(result.contains("info message"));
    }
    
    @Test
    public void testWhatWentWrongSortedByTimestamp() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Error(75), 30, "third error"),
            new LogMessage.LogMessageRecord(new MessageType.Error(60), 10, "first error"),
            new LogMessage.LogMessageRecord(new MessageType.Error(80), 20, "second error")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(3, result.size());
        assertEquals("first error", result.get(0));
        assertEquals("second error", result.get(1));
        assertEquals("third error", result.get(2));
    }
    
    @Test
    public void testWhatWentWrongWithUnknownMessages() {
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Error(60), 10, "valid error"),
            new LogMessage.Unknown("unknown message"),
            new LogMessage.LogMessageRecord(new MessageType.Error(70), 20, "another valid error")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(2, result.size());
        assertTrue(result.contains("valid error"));
        assertTrue(result.contains("another valid error"));
    }
    
    @Test
    public void testWhatWentWrongSampleLog() {
        // Test with the sample log data from the homework
        List<LogMessage> messages = List.of(
            new LogMessage.LogMessageRecord(new MessageType.Info(), 6, "Completed armadillo processing"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 1, "Nothing to report"),
            new LogMessage.LogMessageRecord(new MessageType.Error(99), 10, "Flange failed!"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 4, "Everything normal"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 11, "Initiating self-destruct sequence"),
            new LogMessage.LogMessageRecord(new MessageType.Error(70), 3, "Way too many pickles"),
            new LogMessage.LogMessageRecord(new MessageType.Error(65), 8, "Bad pickle-flange interaction detected"),
            new LogMessage.LogMessageRecord(new MessageType.Warning(), 5, "Flange is due for a check-up"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 7, "Out for lunch, back in two time steps"),
            new LogMessage.LogMessageRecord(new MessageType.Error(20), 2, "Too many pickles"),
            new LogMessage.LogMessageRecord(new MessageType.Info(), 9, "Back from lunch")
        );
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        // According to the homework, should return:
        // ["Way too many pickles", "Bad pickle-flange interaction detected", "Flange failed!"]
        assertEquals(3, result.size());
        assertEquals("Way too many pickles", result.get(0));
        assertEquals("Bad pickle-flange interaction detected", result.get(1));
        assertEquals("Flange failed!", result.get(2));
    }
}