package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

public final class Parser {
    private Parser() {}

    public static LogEntry parseMessage(String line) {
        try {
            if (line == null || line.isBlank()) return new Unknown(line);
            String[] parts = line.split(" ", 4);
            char tag = parts[0].charAt(0);
            switch (tag) {
                case 'I' -> {
                    if (parts.length < 3) return new Unknown(line);
                    int ts = Integer.parseInt(parts[1]);
                    String msg = line.substring(line.indexOf(parts[2]));
                    return new LogMessage(LogMessage.Type.INFO, null, ts, msg);
                }
                case 'W' -> {
                    if (parts.length < 3) return new Unknown(line);
                    int ts = Integer.parseInt(parts[1]);
                    String msg = line.substring(line.indexOf(parts[2]));
                    return new LogMessage(LogMessage.Type.WARNING, null, ts, msg);
                }
                case 'E' -> {
                    String[] p = line.split(" ", 4);
                    if (p.length < 4) return new Unknown(line);
                    int severity = Integer.parseInt(p[1]);
                    int ts = Integer.parseInt(p[2]);
                    String msg = p[3];
                    return new LogMessage(LogMessage.Type.ERROR, severity, ts, msg);
                }
                default -> {
                    return new Unknown(line);
                }
            }
        } catch (Exception e) {
            return new Unknown(line);
        }
    }

    public static List<LogEntry> parse(List<String> lines) {
        List<LogEntry> result = new ArrayList<>();
        for (String line : lines) {
            result.add(parseMessage(line));
        }
        return result;
    }
}
