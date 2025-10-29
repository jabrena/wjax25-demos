package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LogAnalysis class containing implementations for all homework exercises.
 * This class provides functionality to parse log messages, build binary search trees,
 * and extract relevant error information.
 */
public class LogAnalysis {
    
    // Regular expression patterns for parsing log messages
    private static final Pattern INFO_PATTERN = Pattern.compile("^I (\\d+) (.+)$");
    private static final Pattern WARNING_PATTERN = Pattern.compile("^W (\\d+) (.+)$");
    private static final Pattern ERROR_PATTERN = Pattern.compile("^E (\\d+) (\\d+) (.+)$");
    
    /**
     * Exercise 1: Parse an individual log message from a string.
     * 
     * @param line the log line to parse
     * @return LogMessage representing the parsed message or Unknown if parsing fails
     */
    public static LogMessage parseMessage(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new LogMessage.Unknown(line);
        }
        
        // Try to match Info message
        Matcher infoMatcher = INFO_PATTERN.matcher(line.trim());
        if (infoMatcher.matches()) {
            int timeStamp = Integer.parseInt(infoMatcher.group(1));
            String content = infoMatcher.group(2);
            return new LogMessage.LogMessageData(new MessageType.Info(), timeStamp, content);
        }
        
        // Try to match Warning message
        Matcher warningMatcher = WARNING_PATTERN.matcher(line.trim());
        if (warningMatcher.matches()) {
            int timeStamp = Integer.parseInt(warningMatcher.group(1));
            String content = warningMatcher.group(2);
            return new LogMessage.LogMessageData(new MessageType.Warning(), timeStamp, content);
        }
        
        // Try to match Error message
        Matcher errorMatcher = ERROR_PATTERN.matcher(line.trim());
        if (errorMatcher.matches()) {
            int severity = Integer.parseInt(errorMatcher.group(1));
            int timeStamp = Integer.parseInt(errorMatcher.group(2));
            String content = errorMatcher.group(3);
            return new LogMessage.LogMessageData(new MessageType.Error(severity), timeStamp, content);
        }
        
        // If no pattern matches, return Unknown
        return new LogMessage.Unknown(line);
    }
    
    /**
     * Parse an entire log file content into a list of LogMessages.
     * 
     * @param logContent the content of the log file
     * @return list of LogMessages
     */
    public static List<LogMessage> parse(String logContent) {
        if (logContent == null || logContent.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String[] lines = logContent.split("\\r?\\n");
        List<LogMessage> messages = new ArrayList<>();
        
        for (String line : lines) {
            messages.add(parseMessage(line));
        }
        
        return messages;
    }
    
    /**
     * Exercise 2: Insert a LogMessage into a MessageTree.
     * 
     * @param message the LogMessage to insert
     * @param tree the existing MessageTree
     * @return new MessageTree with the message inserted
     */
    public static MessageTree insert(LogMessage message, MessageTree tree) {
        // Unknown messages should not be stored in the tree
        if (message instanceof LogMessage.Unknown) {
            return tree;
        }
        
        if (tree instanceof MessageTree.Leaf) {
            return new MessageTree.Node(new MessageTree.Leaf(), message, new MessageTree.Leaf());
        }
        
        if (tree instanceof MessageTree.Node node) {
            LogMessage.LogMessageData messageData = (LogMessage.LogMessageData) message;
            LogMessage.LogMessageData nodeMessageData = (LogMessage.LogMessageData) node.message();
            
            if (messageData.timeStamp() < nodeMessageData.timeStamp()) {
                return new MessageTree.Node(
                    insert(message, node.left()),
                    node.message(),
                    node.right()
                );
            } else {
                return new MessageTree.Node(
                    node.left(),
                    node.message(),
                    insert(message, node.right())
                );
            }
        }
        
        return tree;
    }
    
    /**
     * Exercise 3: Build a MessageTree from a list of LogMessages.
     * 
     * @param messages list of LogMessages
     * @return MessageTree containing all messages
     */
    public static MessageTree build(List<LogMessage> messages) {
        MessageTree tree = new MessageTree.Leaf();
        
        for (LogMessage message : messages) {
            tree = insert(message, tree);
        }
        
        return tree;
    }
    
    /**
     * Exercise 4: Perform in-order traversal of a MessageTree.
     * 
     * @param tree the MessageTree to traverse
     * @return list of LogMessages sorted by timestamp
     */
    public static List<LogMessage> inOrder(MessageTree tree) {
        List<LogMessage> result = new ArrayList<>();
        
        if (tree instanceof MessageTree.Node node) {
            result.addAll(inOrder(node.left()));
            result.add(node.message());
            result.addAll(inOrder(node.right()));
        }
        
        return result;
    }
    
    /**
     * Exercise 5: Extract error messages with severity >= 50, sorted by timestamp.
     * 
     * @param messages list of LogMessages
     * @return list of error message strings with severity >= 50, sorted by timestamp
     */
    public static List<String> whatWentWrong(List<LogMessage> messages) {
        // First, sort the messages by timestamp
        MessageTree tree = build(messages);
        List<LogMessage> sortedMessages = inOrder(tree);
        
        List<String> result = new ArrayList<>();
        
        for (LogMessage message : sortedMessages) {
            if (message instanceof LogMessage.LogMessageData messageData) {
                if (messageData.messageType() instanceof MessageType.Error error) {
                    if (error.severity() >= 50) {
                        result.add(messageData.content());
                    }
                }
            }
        }
        
        return result;
    }
}