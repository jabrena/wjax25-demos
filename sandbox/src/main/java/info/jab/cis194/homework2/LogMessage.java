package info.jab.cis194.homework2;

/**
 * Represents a log message.
 * This is an algebraic data type with two variants: LogMessage and Unknown.
 */
public sealed interface LogMessage {
    record ValidLogMessage(MessageType messageType, int timeStamp, String message) implements LogMessage {}
    record Unknown(String line) implements LogMessage {}
}
