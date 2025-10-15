package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 4: Extract error messages from a list of log messages.
 * 
 * This exercise involves filtering LogMessage objects to find only error messages
 * and extracting their message content.
 */
public class Exercise4 {
    
    /**
     * Extract error messages from a list of LogMessages.
     * 
     * @param messages the list of log messages to filter
     * @return a list of error message strings
     */
    public static List<String> whatWentWrong(List<LogMessage> messages) {
        List<String> errorMessages = new ArrayList<>();
        
        for (LogMessage message : messages) {
            if (message instanceof LogMessage.ErrorMessage) {
                LogMessage.ErrorMessage errorMessage = (LogMessage.ErrorMessage) message;
                errorMessages.add(errorMessage.getMessage());
            }
        }
        
        return errorMessages;
    }
}