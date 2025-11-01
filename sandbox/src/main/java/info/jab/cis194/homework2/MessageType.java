package info.jab.cis194.homework2;

/**
 * Represents the type of a log message.
 * This is an algebraic data type with three variants: Info, Warning, and Error.
 */
public sealed interface MessageType {
    record Info() implements MessageType {}
    record Warning() implements MessageType {}
    record Error(int severity) implements MessageType {}
}
