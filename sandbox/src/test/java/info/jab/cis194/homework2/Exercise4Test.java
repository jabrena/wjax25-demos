package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise4Test {

    @Test
    public void testWhatWentWrong_NoErrors() {
        LogMessage infoMessage = new LogMessage.InfoMessage(1, "Info message");
        LogMessage warningMessage = new LogMessage.WarningMessage(2, "Warning message");
        
        List<LogMessage> messages = Arrays.asList(infoMessage, warningMessage);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWhatWentWrong_SingleError() {
        LogMessage errorMessage = new LogMessage.ErrorMessage(1, 100, "Error message");
        LogMessage infoMessage = new LogMessage.InfoMessage(2, "Info message");
        
        List<LogMessage> messages = Arrays.asList(errorMessage, infoMessage);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertEquals(1, result.size());
        assertEquals("Error message", result.get(0));
    }

    @Test
    public void testWhatWentWrong_MultipleErrors() {
        LogMessage errorMessage1 = new LogMessage.ErrorMessage(1, 100, "First error");
        LogMessage infoMessage = new LogMessage.InfoMessage(2, "Info message");
        LogMessage errorMessage2 = new LogMessage.ErrorMessage(3, 200, "Second error");
        
        List<LogMessage> messages = Arrays.asList(errorMessage1, infoMessage, errorMessage2);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertEquals(2, result.size());
        assertEquals("First error", result.get(0));
        assertEquals("Second error", result.get(1));
    }

    @Test
    public void testWhatWentWrong_WithUnknownMessages() {
        LogMessage errorMessage = new LogMessage.ErrorMessage(1, 100, "Error message");
        LogMessage unknownMessage = new LogMessage.UnknownMessage("Unknown message");
        LogMessage infoMessage = new LogMessage.InfoMessage(2, "Info message");
        
        List<LogMessage> messages = Arrays.asList(errorMessage, unknownMessage, infoMessage);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertEquals(1, result.size());
        assertEquals("Error message", result.get(0));
    }

    @Test
    public void testWhatWentWrong_EmptyList() {
        List<LogMessage> messages = Arrays.asList();
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWhatWentWrong_OnlyWarnings() {
        LogMessage warningMessage1 = new LogMessage.WarningMessage(1, "Warning 1");
        LogMessage warningMessage2 = new LogMessage.WarningMessage(2, "Warning 2");
        
        List<LogMessage> messages = Arrays.asList(warningMessage1, warningMessage2);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWhatWentWrong_MixedSeverity() {
        LogMessage errorMessage1 = new LogMessage.ErrorMessage(1, 50, "Critical error");
        LogMessage warningMessage = new LogMessage.WarningMessage(2, "Warning message");
        LogMessage errorMessage2 = new LogMessage.ErrorMessage(3, 75, "Another error");
        LogMessage infoMessage = new LogMessage.InfoMessage(4, "Info message");
        
        List<LogMessage> messages = Arrays.asList(errorMessage1, warningMessage, errorMessage2, infoMessage);
        List<String> result = Exercise4.whatWentWrong(messages);
        
        assertEquals(2, result.size());
        assertEquals("Critical error", result.get(0));
        assertEquals("Another error", result.get(1));
    }
}