package info.jab.cis194.homework2;

/**
 * Exercise 1: Parse log messages from strings.
 * 
 * This exercise involves parsing log messages from strings into LogMessage objects.
 * The format is:
 * - Info: "I <timestamp> <message>"
 * - Warning: "W <timestamp> <message>"
 * - Error: "E <timestamp> <errorCode> <message>"
 * - Unknown: anything else
 */
public class Exercise1 {
    
    /**
     * Parse a single log message from a string.
     * 
     * @param logLine the log line to parse
     * @return a LogMessage object representing the parsed message
     */
    public static LogMessage parseMessage(String logLine) {
        if (logLine == null || logLine.trim().isEmpty()) {
            return new LogMessage.UnknownMessage(logLine == null ? "" : logLine);
        }
        
        String[] parts = logLine.trim().split("\\s+", 4);
        
        if (parts.length < 2) {
            return new LogMessage.UnknownMessage(logLine);
        }
        
        String messageType = parts[0];
        
        try {
            switch (messageType) {
                case "I":
                    if (parts.length >= 3) {
                        int timestamp = Integer.parseInt(parts[1]);
                        String message = parts.length > 2 ? String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length)) : "";
                        return new LogMessage.InfoMessage(timestamp, message);
                    }
                    break;
                    
                case "W":
                    if (parts.length >= 3) {
                        int timestamp = Integer.parseInt(parts[1]);
                        String message = parts.length > 2 ? String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length)) : "";
                        return new LogMessage.WarningMessage(timestamp, message);
                    }
                    break;
                    
                case "E":
                    if (parts.length >= 4) {
                        int timestamp = Integer.parseInt(parts[1]);
                        int errorCode = Integer.parseInt(parts[2]);
                        String message = String.join(" ", java.util.Arrays.copyOfRange(parts, 3, parts.length));
                        return new LogMessage.ErrorMessage(timestamp, errorCode, message);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            // If parsing numbers fails, treat as unknown
        }
        
        return new LogMessage.UnknownMessage(logLine);
    }
}