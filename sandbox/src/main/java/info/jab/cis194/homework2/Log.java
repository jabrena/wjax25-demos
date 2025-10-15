package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class for log processing functionality.
 * Based on the Haskell Log module from Log.hs
 */
public class Log {
    
    // Regular expression pattern for parsing log messages
    private static final Pattern LOG_PATTERN = Pattern.compile("^(I|W|E)\\s+(\\d+)\\s+(.*)$");
    
    /**
     * Parse a single log message from a string.
     * Exercise 1: parseMessage
     */
    public static LogMessage parseMessage(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new LogMessage("Empty line");
        }
        
        Matcher matcher = LOG_PATTERN.matcher(line.trim());
        if (matcher.matches()) {
            String typeStr = matcher.group(1);
            int timestamp = Integer.parseInt(matcher.group(2));
            String message = matcher.group(3);
            
            MessageType type;
            switch (typeStr) {
                case "I":
                    type = MessageType.INFO;
                    break;
                case "W":
                    type = MessageType.WARNING;
                    break;
                case "E":
                    type = MessageType.ERROR;
                    break;
                default:
                    return new LogMessage(line);
            }
            
            return new LogMessage(type, timestamp, message);
        } else {
            return new LogMessage(line);
        }
    }
    
    /**
     * Parse multiple log messages from a string containing multiple lines.
     * Exercise 2: parse
     */
    public static List<LogMessage> parse(String logData) {
        List<LogMessage> messages = new ArrayList<>();
        String[] lines = logData.split("\n");
        
        for (String line : lines) {
            messages.add(parseMessage(line));
        }
        
        return messages;
    }
    
    /**
     * Insert a log message into a binary search tree ordered by timestamp.
     * Exercise 3: insert
     */
    public static MessageTree insert(LogMessage message, MessageTree tree) {
        if (tree.isLeaf()) {
            return new MessageTree(new MessageTree(), message, new MessageTree());
        }
        
        if (message.isUnknown()) {
            // Unknown messages go to the left
            return new MessageTree(insert(message, tree.getLeft()), tree.getMessage(), tree.getRight());
        }
        
        int messageTimestamp = message.getTimestamp();
        int treeTimestamp = tree.getMessage().getTimestamp();
        
        if (messageTimestamp <= treeTimestamp) {
            return new MessageTree(insert(message, tree.getLeft()), tree.getMessage(), tree.getRight());
        } else {
            return new MessageTree(tree.getLeft(), tree.getMessage(), insert(message, tree.getRight()));
        }
    }
    
    /**
     * Build a binary search tree from a list of log messages.
     * Exercise 4: build
     */
    public static MessageTree build(List<LogMessage> messages) {
        MessageTree tree = new MessageTree();
        
        for (LogMessage message : messages) {
            tree = insert(message, tree);
        }
        
        return tree;
    }
    
    /**
     * Extract all error messages from a binary search tree.
     * Exercise 5: inOrder
     */
    public static List<String> inOrder(MessageTree tree) {
        List<String> result = new ArrayList<>();
        
        if (tree.isLeaf()) {
            return result;
        }
        
        // In-order traversal: left, root, right
        result.addAll(inOrder(tree.getLeft()));
        
        if (tree.getMessage().getMessageType() == MessageType.ERROR) {
            result.add(tree.getMessage().getMessage());
        }
        
        result.addAll(inOrder(tree.getRight()));
        
        return result;
    }
    
    /**
     * Find what went wrong by parsing a log file and extracting error messages.
     * Exercise 6: whatWentWrong
     */
    public static List<String> whatWentWrong(String logData) {
        List<LogMessage> messages = parse(logData);
        MessageTree tree = build(messages);
        return inOrder(tree);
    }
}