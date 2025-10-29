# CIS 1940 Homework 2: Log Analysis

This package contains the Java implementation of CIS 1940 Homework 2, which focuses on Abstract Data Types (ADTs) and log file parsing.

## Overview

The homework involves parsing log files, building binary search trees, and extracting error information. The original assignment was in Haskell, but this implementation uses Java 25 with modern features like sealed interfaces and record classes.

## Data Types

### MessageType
Represents the type of a log message:
- `Info` - Informational messages
- `Warning` - Warning messages  
- `Error(int severity)` - Error messages with severity level

### LogMessage
Represents a parsed log message:
- `LogMessageData(MessageType, int timestamp, String content)` - Valid log messages
- `Unknown(String content)` - Invalid or malformed log messages

### MessageTree
Binary search tree for storing and sorting log messages by timestamp:
- `Leaf` - Empty tree
- `Node(MessageTree left, LogMessage message, MessageTree right)` - Tree node

## Exercises Implemented

### Exercise 1: parseMessage
Parses individual log lines into LogMessage objects. Supports:
- Info messages: `I <timestamp> <content>`
- Warning messages: `W <timestamp> <content>`
- Error messages: `E <severity> <timestamp> <content>`
- Unknown messages for malformed input

### Exercise 2: insert
Inserts a LogMessage into a MessageTree while maintaining sorted order by timestamp.
Unknown messages are not inserted into the tree.

### Exercise 3: build
Builds a MessageTree from a list of LogMessages by successively inserting each message.

### Exercise 4: inOrder
Performs in-order traversal of a MessageTree, returning messages sorted by timestamp.

### Exercise 5: whatWentWrong
Extracts error messages with severity >= 50, sorted by timestamp.

## Usage

```java
// Parse log content
List<LogMessage> messages = LogAnalysis.parse(logContent);

// Build sorted tree
MessageTree tree = LogAnalysis.build(messages);

// Get sorted messages
List<LogMessage> sorted = LogAnalysis.inOrder(tree);

// Find critical errors
List<String> errors = LogAnalysis.whatWentWrong(messages);
```

## Testing

All exercises are thoroughly tested with JUnit 5:
- `Exercise1Test` - Tests message parsing
- `Exercise2Test` - Tests tree insertion
- `Exercise3Test` - Tests tree building
- `Exercise4Test` - Tests in-order traversal
- `Exercise5Test` - Tests error extraction
- `ParseTest` - Tests log file parsing

## Demo

Run the `Homework2Demo` class to see a complete demonstration of all functionality.

## Build and Test

```bash
# Compile and test
./mvnw clean verify

# Run demo
java -cp sandbox/target/classes info.jab.cis194.homework2.Homework2Demo
```

## Implementation Notes

- Uses Java 25 sealed interfaces and record classes for type safety
- Follows functional programming principles where possible
- Comprehensive error handling and edge case coverage
- All tests pass with 100% success rate
- No external dependencies beyond JUnit for testing