package info.jab.cis194.homework2;

import java.util.List;
import java.util.stream.Collectors;

public final class LogAnalysis {
    private LogAnalysis() {}

    public static List<String> whatWentWrong(List<LogEntry> entries) {
        MessageTree tree = MessageTreeOps.build(entries);
        return MessageTreeOps.inOrder(tree).stream()
                .filter(m -> m.type() == LogMessage.Type.ERROR && m.severity().orElse(0) >= 50)
                .map(LogMessage::content)
                .collect(Collectors.toList());
    }
}
