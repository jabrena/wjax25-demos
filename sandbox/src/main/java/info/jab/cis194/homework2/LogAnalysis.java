package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Log analysis functions for parsing and processing log messages.
 * This class implements the exercises from CIS 194 Homework 2.
 */
public class LogAnalysis {
    
    /**
     * Exercise 1: Parse an individual log message from a string.
     * 
     * @param line the log line to parse
     * @return the parsed LogMessage
     */
    public static LogMessage parseMessage(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new LogMessage.Unknown(line);
        }
        
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length < 2) {
            return new LogMessage.Unknown(line);
        }
        
        try {
            String type = parts[0];
            
            return switch (type) {
                case "I" -> {
                    if (parts.length < 3) {
                        yield new LogMessage.Unknown(line);
                    }
                    int timestamp = Integer.parseInt(parts[1]);
                    String content = String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length));
                    yield new LogMessage.LogMessageRecord(new MessageType.Info(), timestamp, content);
                }
                case "W" -> {
                    if (parts.length < 3) {
                        yield new LogMessage.Unknown(line);
                    }
                    int timestamp = Integer.parseInt(parts[1]);
                    String content = String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length));
                    yield new LogMessage.LogMessageRecord(new MessageType.Warning(), timestamp, content);
                }
                case "E" -> {
                    if (parts.length < 4) {
                        yield new LogMessage.Unknown(line);
                    }
                    int severity = Integer.parseInt(parts[1]);
                    int timestamp = Integer.parseInt(parts[2]);
                    String content = String.join(" ", java.util.Arrays.copyOfRange(parts, 3, parts.length));
                    yield new LogMessage.LogMessageRecord(new MessageType.Error(severity), timestamp, content);
                }
                default -> new LogMessage.Unknown(line);
            };
        } catch (NumberFormatException e) {
            return new LogMessage.Unknown(line);
        }
    }
    
    /**
     * Parse an entire log file and return a list of LogMessages.
     * 
     * @param logContent the content of the log file
     * @return list of parsed LogMessages
     */
    public static List<LogMessage> parse(String logContent) {
        if (logContent == null || logContent.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return logContent.lines()
                .map(LogAnalysis::parseMessage)
                .collect(Collectors.toList());
    }
    
    /**
     * Exercise 2: Insert a LogMessage into a MessageTree.
     * 
     * @param message the message to insert
     * @param tree the tree to insert into
     * @return a new tree with the message inserted
     */
    public static MessageTree insert(LogMessage message, MessageTree tree) {
        if (message instanceof LogMessage.Unknown) {
            return tree; // Unknown messages should not be stored
        }
        
        if (message instanceof LogMessage.LogMessageRecord logMsg) {
            return insertLogMessage(logMsg, tree);
        }
        
        return tree;
    }
    
    private static MessageTree insertLogMessage(LogMessage.LogMessageRecord message, MessageTree tree) {
        return switch (tree) {
            case MessageTree.Leaf() -> new MessageTree.Node(new MessageTree.Leaf(), message, new MessageTree.Leaf());
            case MessageTree.Node(var left, var nodeMessage, var right) -> {
                if (nodeMessage instanceof LogMessage.LogMessageRecord nodeLogMsg) {
                    if (message.timestamp() < nodeLogMsg.timestamp()) {
                        yield new MessageTree.Node(insertLogMessage(message, left), nodeMessage, right);
                    } else {
                        yield new MessageTree.Node(left, nodeMessage, insertLogMessage(message, right));
                    }
                } else {
                    yield tree; // Should not happen with proper usage
                }
            }
        };
    }
    
    /**
     * Exercise 3: Build a MessageTree from a list of LogMessages.
     * 
     * @param messages the list of messages to build the tree from
     * @return a MessageTree containing all the messages
     */
    public static MessageTree build(List<LogMessage> messages) {
        MessageTree tree = new MessageTree.Leaf();
        for (LogMessage message : messages) {
            tree = insert(message, tree);
        }
        return tree;
    }
    
    /**
     * Exercise 4: Perform an in-order traversal of a MessageTree.
     * 
     * @param tree the tree to traverse
     * @return a list of LogMessages sorted by timestamp
     */
    public static List<LogMessage> inOrder(MessageTree tree) {
        return switch (tree) {
            case MessageTree.Leaf() -> new ArrayList<>();
            case MessageTree.Node(var left, var message, var right) -> {
                List<LogMessage> result = new ArrayList<>();
                result.addAll(inOrder(left));
                result.add(message);
                result.addAll(inOrder(right));
                yield result;
            }
        };
    }
    
    /**
     * Exercise 5: Extract error messages with severity >= 50, sorted by timestamp.
     * 
     * @param messages the list of log messages to process
     * @return list of error messages with severity >= 50, sorted by timestamp
     */
    public static List<String> whatWentWrong(List<LogMessage> messages) {
        return inOrder(build(messages))
                .stream()
                .filter(msg -> msg instanceof LogMessage.LogMessageRecord logMsg && 
                              logMsg.messageType() instanceof MessageType.Error error &&
                              error.severity() >= 50)
                .map(msg -> ((LogMessage.LogMessageRecord) msg).content())
                .collect(Collectors.toList());
    }
}