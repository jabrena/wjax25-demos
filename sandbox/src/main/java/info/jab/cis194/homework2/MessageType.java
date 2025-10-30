package info.jab.cis194.homework2;

import java.util.Objects;

/**
 * Message type for log entries. ERROR includes a required severity.
 */
public final class MessageType {

    public enum Kind { INFO, WARNING, ERROR }

    private final Kind kind;
    private final Integer errorSeverity; // only for ERROR

    public static final MessageType INFO = new MessageType(Kind.INFO, null);
    public static final MessageType WARNING = new MessageType(Kind.WARNING, null);

    public static MessageType error(int severity) {
        return new MessageType(Kind.ERROR, severity);
    }

    private MessageType(Kind kind, Integer errorSeverity) {
        this.kind = kind;
        this.errorSeverity = errorSeverity;
    }

    public Kind kind() { return kind; }
    public Integer errorSeverity() { return errorSeverity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageType other)) return false;
        return kind == other.kind && Objects.equals(errorSeverity, other.errorSeverity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, errorSeverity);
    }

    @Override
    public String toString() {
        return switch (kind) {
            case INFO -> "INFO";
            case WARNING -> "WARNING";
            case ERROR -> "ERROR(" + errorSeverity + ")";
        };
    }
}
