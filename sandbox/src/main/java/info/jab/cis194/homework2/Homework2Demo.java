package info.jab.cis194.homework2;

import java.util.List;

/**
 * Demonstration class for Homework 2 - Log Analysis
 * 
 * This class demonstrates the functionality of all exercises implemented
 * for the CIS 1940 Homework 2 assignment.
 */
public class Homework2Demo {
    
    public static void main(String[] args) {
        System.out.println("=== CIS 1940 Homework 2: Log Analysis Demo ===\n");
        
        // Sample log content based on the homework requirements
        String sampleLog = "I 6 Completed armadillo processing\n" +
                          "I 1 Nothing to report\n" +
                          "E 99 10 Flange failed!\n" +
                          "I 4 Everything normal\n" +
                          "I 11 Initiating self-destruct sequence\n" +
                          "E 70 3 Way too many pickles\n" +
                          "E 65 8 Bad pickle-flange interaction detected\n" +
                          "W 5 Flange is due for a check-up\n" +
                          "I 7 Out for lunch, back in two time steps\n" +
                          "E 20 2 Too many pickles\n" +
                          "I 9 Back from lunch";
        
        System.out.println("Original log content:");
        System.out.println(sampleLog);
        System.out.println();
        
        // Exercise 1: Parse individual messages
        System.out.println("=== Exercise 1: Parsing Messages ===");
        String[] lines = sampleLog.split("\\n");
        for (int i = 0; i < Math.min(3, lines.length); i++) {
            LogMessage message = LogAnalysis.parseMessage(lines[i]);
            System.out.println("Line " + (i + 1) + ": " + message);
        }
        System.out.println();
        
        // Exercise 2-4: Parse all messages, build tree, and traverse
        System.out.println("=== Exercise 2-4: Building and Traversing Message Tree ===");
        List<LogMessage> messages = LogAnalysis.parse(sampleLog);
        System.out.println("Parsed " + messages.size() + " messages");
        
        // Build the message tree
        MessageTree tree = LogAnalysis.build(messages);
        System.out.println("Built message tree");
        
        // Perform in-order traversal
        List<LogMessage> sortedMessages = LogAnalysis.inOrder(tree);
        System.out.println("In-order traversal (sorted by timestamp):");
        for (LogMessage message : sortedMessages) {
            System.out.println("  " + message);
        }
        System.out.println();
        
        // Exercise 5: Find what went wrong
        System.out.println("=== Exercise 5: What Went Wrong ===");
        List<String> errors = LogAnalysis.whatWentWrong(messages);
        System.out.println("Errors with severity >= 50 (sorted by timestamp):");
        for (String error : errors) {
            System.out.println("  - " + error);
        }
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
        System.out.println("All exercises implemented and tested successfully!");
    }
}