package info.jab.cis194.homework2;

/**
 * Represents the type of a log message.
 * Equivalent to the Haskell MessageType data type.
 */
public sealed interface MessageType permits MessageType.Info, MessageType.Warning, MessageType.Error {
    
    record Info() implements MessageType {
        @Override
        public String toString() {
            return "Info";
        }
    }
    
    record Warning() implements MessageType {
        @Override
        public String toString() {
            return "Warning";
        }
    }
    
    record Error(int severity) implements MessageType {
        @Override
        public String toString() {
            return "Error(" + severity + ")";
        }
    }
}