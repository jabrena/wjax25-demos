package info.jab.cis194.homework2;

/**
 * Represents a log message with different types: Info, Warning, Error, or Unknown.
 * This is the Java equivalent of the Haskell algebraic data type.
 */
public abstract class LogMessage {
    
    /**
     * Info message with timestamp and message content.
     */
    public static class InfoMessage extends LogMessage {
        private final int timestamp;
        private final String message;
        
        public InfoMessage(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
        
        public int getTimestamp() {
            return timestamp;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            InfoMessage that = (InfoMessage) obj;
            return timestamp == that.timestamp && 
                   java.util.Objects.equals(message, that.message);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(timestamp, message);
        }
        
        @Override
        public String toString() {
            return "InfoMessage{timestamp=" + timestamp + ", message='" + message + "'}";
        }
    }
    
    /**
     * Warning message with timestamp and message content.
     */
    public static class WarningMessage extends LogMessage {
        private final int timestamp;
        private final String message;
        
        public WarningMessage(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
        
        public int getTimestamp() {
            return timestamp;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            WarningMessage that = (WarningMessage) obj;
            return timestamp == that.timestamp && 
                   java.util.Objects.equals(message, that.message);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(timestamp, message);
        }
        
        @Override
        public String toString() {
            return "WarningMessage{timestamp=" + timestamp + ", message='" + message + "'}";
        }
    }
    
    /**
     * Error message with timestamp, error code, and message content.
     */
    public static class ErrorMessage extends LogMessage {
        private final int timestamp;
        private final int errorCode;
        private final String message;
        
        public ErrorMessage(int timestamp, int errorCode, String message) {
            this.timestamp = timestamp;
            this.errorCode = errorCode;
            this.message = message;
        }
        
        public int getTimestamp() {
            return timestamp;
        }
        
        public int getErrorCode() {
            return errorCode;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ErrorMessage that = (ErrorMessage) obj;
            return timestamp == that.timestamp && 
                   errorCode == that.errorCode &&
                   java.util.Objects.equals(message, that.message);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(timestamp, errorCode, message);
        }
        
        @Override
        public String toString() {
            return "ErrorMessage{timestamp=" + timestamp + ", errorCode=" + errorCode + ", message='" + message + "'}";
        }
    }
    
    /**
     * Unknown message format.
     */
    public static class UnknownMessage extends LogMessage {
        private final String message;
        
        public UnknownMessage(String message) {
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            UnknownMessage that = (UnknownMessage) obj;
            return java.util.Objects.equals(message, that.message);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(message);
        }
        
        @Override
        public String toString() {
            return "UnknownMessage{message='" + message + "'}";
        }
    }
}