package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

public final class LogParser {

    private LogParser() {}

    public static Entry parseMessage(String line) {
        if (line == null || line.isBlank()) {
            return new Unknown(line == null ? "" : line);
        }
        String[] parts = line.split(" ", 2);
        if (parts.length < 2) return new Unknown(line);
        String tag = parts[0];
        String rest = parts[1];
        try {
            return switch (tag) {
                case "I" -> parseInfo(rest);
                case "W" -> parseWarning(rest);
                case "E" -> parseError(rest);
                default -> new Unknown(line);
            };
        } catch (RuntimeException ex) {
            return new Unknown(line);
        }
    }

    private static LogMessage parseInfo(String rest) {
        String[] parts = rest.split(" ", 2);
        int ts = Integer.parseInt(parts[0]);
        String msg = parts.length > 1 ? parts[1] : "";
        return new LogMessage(MessageType.INFO, ts, msg);
    }

    private static LogMessage parseWarning(String rest) {
        String[] parts = rest.split(" ", 2);
        int ts = Integer.parseInt(parts[0]);
        String msg = parts.length > 1 ? parts[1] : "";
        return new LogMessage(MessageType.WARNING, ts, msg);
    }

    private static LogMessage parseError(String rest) {
        String[] parts1 = rest.split(" ", 2);
        int severity = Integer.parseInt(parts1[0]);
        String[] parts2 = parts1[1].split(" ", 2);
        int ts = Integer.parseInt(parts2[0]);
        String msg = parts2.length > 1 ? parts2[1] : "";
        return new LogMessage(MessageType.error(severity), ts, msg);
    }

    public static List<Entry> parse(String input) {
        List<Entry> entries = new ArrayList<>();
        if (input == null || input.isBlank()) return entries;
        String[] lines = input.split("\n");
        for (String line : lines) {
            entries.add(parseMessage(line));
        }
        return entries;
    }
}
