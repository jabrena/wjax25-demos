package info.jab.cis194.homework2;

/**
 * Represents a log message.
 * Equivalent to the Haskell LogMessage data type.
 */
public sealed interface LogMessage permits LogMessage.LogMessageData, LogMessage.Unknown {
    
    record LogMessageData(MessageType messageType, int timeStamp, String content) implements LogMessage {
        @Override
        public String toString() {
            return "LogMessage(" + messageType + ", " + timeStamp + ", \"" + content + "\")";
        }
    }
    
    record Unknown(String content) implements LogMessage {
        @Override
        public String toString() {
            return "Unknown(\"" + content + "\")";
        }
    }
}