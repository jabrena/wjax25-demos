package info.jab.cis194.homework2;

import java.util.Optional;

public record LogMessage(Type type, Integer errorSeverityNullable, int timestamp, String content) implements LogEntry {

    public enum Type { INFO, WARNING, ERROR }

    public Optional<Integer> severity() {
        return type == Type.ERROR ? Optional.ofNullable(errorSeverityNullable) : Optional.empty();
    }
}
