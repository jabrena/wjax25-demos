package info.jab.cis194.homework2;

/**
 * Represents the type of a log message.
 * This is equivalent to the Haskell MessageType data type.
 */
public sealed interface MessageType {
    
    /**
     * Information message type
     */
    record Info() implements MessageType {
        @Override
        public String toString() {
            return "Info";
        }
    }
    
    /**
     * Warning message type
     */
    record Warning() implements MessageType {
        @Override
        public String toString() {
            return "Warning";
        }
    }
    
    /**
     * Error message type with severity level
     * @param severity the severity level of the error (1-100)
     */
    record Error(int severity) implements MessageType {
        @Override
        public String toString() {
            return "Error(" + severity + ")";
        }
    }
}