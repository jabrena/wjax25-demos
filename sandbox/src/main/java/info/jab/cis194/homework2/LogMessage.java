package info.jab.cis194.homework2;

/**
 * Represents a log message with type, timestamp, and content.
 * Based on the Haskell LogMessage from Log.hs
 */
public class LogMessage {
    private final MessageType messageType;
    private final int timestamp;
    private final String message;
    private final boolean isUnknown;
    
    // Constructor for known message types
    public LogMessage(MessageType messageType, int timestamp, String message) {
        this.messageType = messageType;
        this.timestamp = timestamp;
        this.message = message;
        this.isUnknown = false;
    }
    
    // Constructor for unknown messages
    public LogMessage(String unknownMessage) {
        this.messageType = null;
        this.timestamp = 0;
        this.message = unknownMessage;
        this.isUnknown = true;
    }
    
    public MessageType getMessageType() {
        return messageType;
    }
    
    public int getTimestamp() {
        return timestamp;
    }
    
    public String getMessage() {
        return message;
    }
    
    public boolean isUnknown() {
        return isUnknown;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        LogMessage that = (LogMessage) obj;
        
        if (timestamp != that.timestamp) return false;
        if (isUnknown != that.isUnknown) return false;
        if (messageType != that.messageType) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }
    
    @Override
    public int hashCode() {
        int result = messageType != null ? messageType.hashCode() : 0;
        result = 31 * result + timestamp;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (isUnknown ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        if (isUnknown) {
            return "Unknown(" + message + ")";
        } else {
            return "LogMessage(" + messageType + ", " + timestamp + ", " + message + ")";
        }
    }
}