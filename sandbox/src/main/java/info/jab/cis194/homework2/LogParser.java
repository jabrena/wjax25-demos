package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Parser and processor for log messages.
 */
public class LogParser {

    private static final Pattern INFO_PATTERN = Pattern.compile("^I (\\d+) (.+)$");
    private static final Pattern WARNING_PATTERN = Pattern.compile("^W (\\d+) (.+)$");
    private static final Pattern ERROR_PATTERN = Pattern.compile("^E (\\d+) (\\d+) (.+)$");

    /**
     * Parses a single line of log input into a LogMessage.
     * 
     * @param line the line to parse
     * @return a LogMessage (ValidLogMessage if parsing succeeds, Unknown otherwise)
     */
    public static LogMessage parseMessage(String line) {
        if (line == null || line.isBlank()) {
            return new LogMessage.Unknown(line == null ? "" : line);
        }

        var infoMatcher = INFO_PATTERN.matcher(line);
        if (infoMatcher.matches()) {
            int timestamp = Integer.parseInt(infoMatcher.group(1));
            String message = infoMatcher.group(2);
            return new LogMessage.ValidLogMessage(new MessageType.Info(), timestamp, message);
        }

        var warningMatcher = WARNING_PATTERN.matcher(line);
        if (warningMatcher.matches()) {
            int timestamp = Integer.parseInt(warningMatcher.group(1));
            String message = warningMatcher.group(2);
            return new LogMessage.ValidLogMessage(new MessageType.Warning(), timestamp, message);
        }

        var errorMatcher = ERROR_PATTERN.matcher(line);
        if (errorMatcher.matches()) {
            int severity = Integer.parseInt(errorMatcher.group(1));
            int timestamp = Integer.parseInt(errorMatcher.group(2));
            String message = errorMatcher.group(3);
            return new LogMessage.ValidLogMessage(new MessageType.Error(severity), timestamp, message);
        }

        return new LogMessage.Unknown(line);
    }

    /**
     * Parses an entire log file string into a list of LogMessages.
     * 
     * @param logContent the entire log file content as a string
     * @return a list of LogMessages
     */
    public static List<LogMessage> parse(String logContent) {
        List<LogMessage> messages = new ArrayList<>();
        if (logContent == null || logContent.isBlank()) {
            return messages;
        }

        String[] lines = logContent.split("\n");
        for (String line : lines) {
            messages.add(parseMessage(line.trim()));
        }
        return messages;
    }

    /**
     * Inserts a LogMessage into a MessageTree, maintaining BST order by timestamp.
     * Only ValidLogMessage instances are inserted; Unknown messages are ignored.
     * 
     * @param tree the MessageTree to insert into
     * @param msg the LogMessage to insert
     * @return a new MessageTree with the message inserted
     */
    public static MessageTree insert(MessageTree tree, LogMessage msg) {
        if (msg instanceof LogMessage.Unknown) {
            return tree;
        }

        LogMessage.ValidLogMessage validMsg = (LogMessage.ValidLogMessage) msg;
        return switch (tree) {
            case MessageTree.Leaf() -> new MessageTree.Node(new MessageTree.Leaf(), validMsg, new MessageTree.Leaf());
            case MessageTree.Node(var left, var nodeMsg, var right) -> {
                if (validMsg.timeStamp() < nodeMsg.timeStamp()) {
                    yield new MessageTree.Node(insert(left, msg), nodeMsg, right);
                } else {
                    yield new MessageTree.Node(left, nodeMsg, insert(right, msg));
                }
            }
        };
    }

    /**
     * Builds a MessageTree from a list of LogMessages.
     * 
     * @param messages the list of LogMessages
     * @return a MessageTree containing all valid log messages
     */
    public static MessageTree build(List<LogMessage> messages) {
        MessageTree tree = new MessageTree.Leaf();
        for (LogMessage msg : messages) {
            tree = insert(tree, msg);
        }
        return tree;
    }

    /**
     * Traverses a MessageTree in-order and returns a list of LogMessages.
     * 
     * @param tree the MessageTree to traverse
     * @return a list of LogMessages in chronological order
     */
    public static List<LogMessage.ValidLogMessage> inOrder(MessageTree tree) {
        return switch (tree) {
            case MessageTree.Leaf() -> new ArrayList<>();
            case MessageTree.Node(var left, var msg, var right) -> {
                List<LogMessage.ValidLogMessage> result = new ArrayList<>();
                result.addAll(inOrder(left));
                result.add(msg);
                result.addAll(inOrder(right));
                yield result;
            }
        };
    }

    /**
     * Extracts error messages with severity >= 50 from a log file,
     * sorted chronologically.
     * 
     * @param logContent the entire log file content as a string
     * @return a list of error messages (strings) with severity >= 50, sorted by timestamp
     */
    public static List<String> whatWentWrong(String logContent) {
        List<LogMessage> messages = parse(logContent);
        MessageTree tree = build(messages);
        List<LogMessage.ValidLogMessage> orderedMessages = inOrder(tree);

        return orderedMessages.stream()
                .filter(msg -> msg.messageType() instanceof MessageType.Error error && error.severity() >= 50)
                .map(LogMessage.ValidLogMessage::message)
                .toList();
    }
}
