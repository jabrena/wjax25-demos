package info.jab.cis194.homework2;

import java.util.List;
import java.util.Objects;

public final class LogAnalysis {
    private LogAnalysis() {}

    public static List<String> whatWentWrong(List<Entry> entries) {
        MessageTree tree = MessageTree.build(entries);
        return tree.inOrder().stream()
            .filter(lm -> lm.type().kind() == MessageType.Kind.ERROR)
            .filter(lm -> Objects.requireNonNull(lm.type().errorSeverity()) >= 50)
            .map(LogMessage::message)
            .toList();
    }
}
