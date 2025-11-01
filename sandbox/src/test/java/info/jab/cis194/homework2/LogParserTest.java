package info.jab.cis194.homework2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LogParser Tests")
class LogParserTest {

    @Nested
    @DisplayName("parseMessage Tests")
    class ParseMessageTests {

        @Test
        @DisplayName("Should parse Info message correctly")
        void shouldParseInfoMessage() {
            String line = "I 6 Completed armadillo processing";
            LogMessage result = LogParser.parseMessage(line);

            assertThat(result).isInstanceOf(LogMessage.ValidLogMessage.class);
            LogMessage.ValidLogMessage validMsg = (LogMessage.ValidLogMessage) result;
            assertThat(validMsg.messageType()).isInstanceOf(MessageType.Info.class);
            assertThat(validMsg.timeStamp()).isEqualTo(6);
            assertThat(validMsg.message()).isEqualTo("Completed armadillo processing");
        }

        @Test
        @DisplayName("Should parse Warning message correctly")
        void shouldParseWarningMessage() {
            String line = "W 5 Flange is due for a check-up";
            LogMessage result = LogParser.parseMessage(line);

            assertThat(result).isInstanceOf(LogMessage.ValidLogMessage.class);
            LogMessage.ValidLogMessage validMsg = (LogMessage.ValidLogMessage) result;
            assertThat(validMsg.messageType()).isInstanceOf(MessageType.Warning.class);
            assertThat(validMsg.timeStamp()).isEqualTo(5);
            assertThat(validMsg.message()).isEqualTo("Flange is due for a check-up");
        }

        @Test
        @DisplayName("Should parse Error message correctly")
        void shouldParseErrorMessage() {
            String line = "E 70 3 Way too many pickles";
            LogMessage result = LogParser.parseMessage(line);

            assertThat(result).isInstanceOf(LogMessage.ValidLogMessage.class);
            LogMessage.ValidLogMessage validMsg = (LogMessage.ValidLogMessage) result;
            assertThat(validMsg.messageType()).isInstanceOf(MessageType.Error.class);
            MessageType.Error error = (MessageType.Error) validMsg.messageType();
            assertThat(error.severity()).isEqualTo(70);
            assertThat(validMsg.timeStamp()).isEqualTo(3);
            assertThat(validMsg.message()).isEqualTo("Way too many pickles");
        }

        @Test
        @DisplayName("Should return Unknown for invalid message format")
        void shouldReturnUnknownForInvalidFormat() {
            String line = "Invalid log line";
            LogMessage result = LogParser.parseMessage(line);

            assertThat(result).isInstanceOf(LogMessage.Unknown.class);
            LogMessage.Unknown unknown = (LogMessage.Unknown) result;
            assertThat(unknown.line()).isEqualTo("Invalid log line");
        }

        @Test
        @DisplayName("Should return Unknown for empty line")
        void shouldReturnUnknownForEmptyLine() {
            LogMessage result = LogParser.parseMessage("");
            assertThat(result).isInstanceOf(LogMessage.Unknown.class);
        }

        @Test
        @DisplayName("Should return Unknown for null line")
        void shouldReturnUnknownForNullLine() {
            LogMessage result = LogParser.parseMessage(null);
            assertThat(result).isInstanceOf(LogMessage.Unknown.class);
        }
    }

    @Nested
    @DisplayName("parse Tests")
    class ParseTests {

        @Test
        @DisplayName("Should parse multiple log lines")
        void shouldParseMultipleLogLines() {
            String logContent = """
                I 6 Completed armadillo processing
                I 1 Nothing to report
                E 70 3 Way too many pickles
                W 5 Flange is due for a check-up
                """;

            List<LogMessage> messages = LogParser.parse(logContent);

            assertThat(messages).hasSize(4);
            assertThat(messages.get(0)).isInstanceOf(LogMessage.ValidLogMessage.class);
            assertThat(messages.get(1)).isInstanceOf(LogMessage.ValidLogMessage.class);
            assertThat(messages.get(2)).isInstanceOf(LogMessage.ValidLogMessage.class);
            assertThat(messages.get(3)).isInstanceOf(LogMessage.ValidLogMessage.class);
        }

        @Test
        @DisplayName("Should handle empty log content")
        void shouldHandleEmptyLogContent() {
            List<LogMessage> messages = LogParser.parse("");
            assertThat(messages).isEmpty();
        }

        @Test
        @DisplayName("Should handle null log content")
        void shouldHandleNullLogContent() {
            List<LogMessage> messages = LogParser.parse(null);
            assertThat(messages).isEmpty();
        }
    }

    @Nested
    @DisplayName("insert Tests")
    class InsertTests {

        @Test
        @DisplayName("Should insert message into empty tree")
        void shouldInsertIntoEmptyTree() {
            MessageTree tree = new MessageTree.Leaf();
            LogMessage msg = new LogMessage.ValidLogMessage(new MessageType.Info(), 5, "Test message");

            MessageTree result = LogParser.insert(tree, msg);

            assertThat(result).isInstanceOf(MessageTree.Node.class);
            MessageTree.Node node = (MessageTree.Node) result;
            assertThat(node.logMessage().timeStamp()).isEqualTo(5);
        }

        @Test
        @DisplayName("Should maintain BST property when inserting")
        void shouldMaintainBSTProperty() {
            MessageTree tree = new MessageTree.Leaf();
            LogMessage msg1 = new LogMessage.ValidLogMessage(new MessageType.Info(), 5, "First");
            LogMessage msg2 = new LogMessage.ValidLogMessage(new MessageType.Info(), 3, "Second");
            LogMessage msg3 = new LogMessage.ValidLogMessage(new MessageType.Info(), 7, "Third");

            tree = LogParser.insert(tree, msg1);
            tree = LogParser.insert(tree, msg2);
            tree = LogParser.insert(tree, msg3);

            List<LogMessage.ValidLogMessage> inOrder = LogParser.inOrder(tree);
            assertThat(inOrder).hasSize(3);
            assertThat(inOrder.get(0).timeStamp()).isEqualTo(3);
            assertThat(inOrder.get(1).timeStamp()).isEqualTo(5);
            assertThat(inOrder.get(2).timeStamp()).isEqualTo(7);
        }

        @Test
        @DisplayName("Should ignore Unknown messages when inserting")
        void shouldIgnoreUnknownMessages() {
            MessageTree tree = new MessageTree.Leaf();
            LogMessage unknown = new LogMessage.Unknown("Invalid line");

            MessageTree result = LogParser.insert(tree, unknown);

            assertThat(result).isInstanceOf(MessageTree.Leaf.class);
        }
    }

    @Nested
    @DisplayName("build Tests")
    class BuildTests {

        @Test
        @DisplayName("Should build tree from list of messages")
        void shouldBuildTreeFromList() {
            List<LogMessage> messages = List.of(
                new LogMessage.ValidLogMessage(new MessageType.Info(), 5, "First"),
                new LogMessage.ValidLogMessage(new MessageType.Info(), 3, "Second"),
                new LogMessage.ValidLogMessage(new MessageType.Info(), 7, "Third")
            );

            MessageTree tree = LogParser.build(messages);

            List<LogMessage.ValidLogMessage> inOrder = LogParser.inOrder(tree);
            assertThat(inOrder).hasSize(3);
            assertThat(inOrder.get(0).timeStamp()).isEqualTo(3);
            assertThat(inOrder.get(1).timeStamp()).isEqualTo(5);
            assertThat(inOrder.get(2).timeStamp()).isEqualTo(7);
        }

        @Test
        @DisplayName("Should build empty tree from empty list")
        void shouldBuildEmptyTreeFromEmptyList() {
            MessageTree tree = LogParser.build(List.of());
            assertThat(tree).isInstanceOf(MessageTree.Leaf.class);
        }
    }

    @Nested
    @DisplayName("inOrder Tests")
    class InOrderTests {

        @Test
        @DisplayName("Should return empty list for leaf")
        void shouldReturnEmptyListForLeaf() {
            MessageTree tree = new MessageTree.Leaf();
            List<LogMessage.ValidLogMessage> result = LogParser.inOrder(tree);
            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("Should return messages in chronological order")
        void shouldReturnMessagesInChronologicalOrder() {
            MessageTree tree = LogParser.build(List.of(
                new LogMessage.ValidLogMessage(new MessageType.Info(), 5, "Five"),
                new LogMessage.ValidLogMessage(new MessageType.Info(), 1, "One"),
                new LogMessage.ValidLogMessage(new MessageType.Info(), 9, "Nine"),
                new LogMessage.ValidLogMessage(new MessageType.Info(), 3, "Three")
            ));

            List<LogMessage.ValidLogMessage> result = LogParser.inOrder(tree);

            assertThat(result).hasSize(4);
            assertThat(result.get(0).timeStamp()).isEqualTo(1);
            assertThat(result.get(1).timeStamp()).isEqualTo(3);
            assertThat(result.get(2).timeStamp()).isEqualTo(5);
            assertThat(result.get(3).timeStamp()).isEqualTo(9);
        }
    }

    @Nested
    @DisplayName("whatWentWrong Tests")
    class WhatWentWrongTests {

        @Test
        @DisplayName("Should extract errors with severity >= 50")
        void shouldExtractHighSeverityErrors() {
            String logContent = """
                I 6 Completed armadillo processing
                E 70 3 Way too many pickles
                E 65 8 Bad pickle-flange interaction detected
                W 5 Flange is due for a check-up
                E 20 2 Too many pickles
                E 99 10 Flange failed!
                """;

            List<String> result = LogParser.whatWentWrong(logContent);

            assertThat(result).hasSize(3);
            assertThat(result).containsExactly(
                "Way too many pickles",
                "Bad pickle-flange interaction detected",
                "Flange failed!"
            );
        }

        @Test
        @DisplayName("Should return empty list when no high severity errors")
        void shouldReturnEmptyListWhenNoHighSeverityErrors() {
            String logContent = """
                I 6 Completed armadillo processing
                E 20 2 Too many pickles
                E 30 5 Minor issue
                W 5 Flange is due for a check-up
                """;

            List<String> result = LogParser.whatWentWrong(logContent);

            assertThat(result).isEmpty();
        }

        @Test
        @DisplayName("Should handle sample.log correctly")
        void shouldHandleSampleLog() {
            String logContent = """
                I 6 Completed armadillo processing
                I 1 Nothing to report
                I 4 Everything normal
                I 11 Initiating self-destruct sequence
                E 70 3 Way too many pickles
                E 65 8 Bad pickle-flange interaction detected
                W 5 Flange is due for a check-up
                I 7 Out for lunch, back in two time steps
                E 20 2 Too many pickles
                I 9 Back from lunch
                E 99 10 Flange failed!
                """;

            List<String> result = LogParser.whatWentWrong(logContent);

            assertThat(result).hasSize(3);
            assertThat(result).containsExactly(
                "Way too many pickles",
                "Bad pickle-flange interaction detected",
                "Flange failed!"
            );
        }
    }
}
