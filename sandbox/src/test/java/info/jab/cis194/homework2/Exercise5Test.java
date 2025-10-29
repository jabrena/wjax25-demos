package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for Exercise 5: whatWentWrong function
 */
public class Exercise5Test {
    
    @Test
    public void testWhatWentWrongEmptyList() {
        List<LogMessage> messages = new ArrayList<>();
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongNoErrors() {
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 10, "info message"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Warning(), 20, "warning message"
        ));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongLowSeverityErrors() {
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(10), 10, "low severity error"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(49), 20, "almost high severity error"
        ));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testWhatWentWrongHighSeverityErrors() {
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(50), 20, "high severity error 1"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(75), 10, "high severity error 2"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(100), 30, "critical error"
        ));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(3, result.size());
        assertEquals("high severity error 2", result.get(0)); // timestamp 10
        assertEquals("high severity error 1", result.get(1)); // timestamp 20
        assertEquals("critical error", result.get(2));        // timestamp 30
    }
    
    @Test
    public void testWhatWentWrongMixedMessages() {
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 5, "info message"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(25), 10, "low severity error"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Warning(), 15, "warning message"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(60), 20, "high severity error"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(80), 25, "critical error"
        ));
        messages.add(new LogMessage.Unknown("unknown message"));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(2, result.size());
        assertEquals("high severity error", result.get(0)); // timestamp 20
        assertEquals("critical error", result.get(1));      // timestamp 25
    }
    
    @Test
    public void testWhatWentWrongSampleLog() {
        // Test with the sample log data from the homework
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 6, "Completed armadillo processing"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 1, "Nothing to report"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(99), 10, "Flange failed!"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 4, "Everything normal"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 11, "Initiating self-destruct sequence"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(70), 3, "Way too many pickles"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(65), 8, "Bad pickle-flange interaction detected"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Warning(), 5, "Flange is due for a check-up"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 7, "Out for lunch, back in two time steps"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(20), 2, "Too many pickles"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Info(), 9, "Back from lunch"
        ));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(3, result.size());
        assertEquals("Way too many pickles", result.get(0));                    // timestamp 3
        assertEquals("Bad pickle-flange interaction detected", result.get(1));  // timestamp 8
        assertEquals("Flange failed!", result.get(2));                         // timestamp 10
    }
    
    @Test
    public void testWhatWentWrongUnsortedInput() {
        // Test that the function works with unsorted input
        List<LogMessage> messages = new ArrayList<>();
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(60), 30, "error 3"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(70), 10, "error 1"
        ));
        messages.add(new LogMessage.LogMessageData(
            new MessageType.Error(80), 20, "error 2"
        ));
        
        List<String> result = LogAnalysis.whatWentWrong(messages);
        
        assertEquals(3, result.size());
        assertEquals("error 1", result.get(0)); // timestamp 10
        assertEquals("error 2", result.get(1)); // timestamp 20
        assertEquals("error 3", result.get(2)); // timestamp 30
    }
}