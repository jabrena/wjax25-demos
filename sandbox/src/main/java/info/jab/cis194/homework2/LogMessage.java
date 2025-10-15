package info.jab.cis194.homework2;

/**
 * Represents a log message.
 * This is equivalent to the Haskell LogMessage data type.
 */
public sealed interface LogMessage {
    
    /**
     * A properly formatted log message with type, timestamp, and content
     * @param messageType the type of the message
     * @param timestamp the timestamp of the message
     * @param content the content of the message
     */
    record LogMessageRecord(MessageType messageType, int timestamp, String content) implements LogMessage {
        @Override
        public String toString() {
            return "LogMessage(" + messageType + ", " + timestamp + ", \"" + content + "\")";
        }
    }
    
    /**
     * An unknown or malformed log message
     * @param content the raw content of the unknown message
     */
    record Unknown(String content) implements LogMessage {
        @Override
        public String toString() {
            return "Unknown(\"" + content + "\")";
        }
    }
}