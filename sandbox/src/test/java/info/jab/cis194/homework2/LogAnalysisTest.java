package info.jab.cis194.homework2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LogAnalysisTest {

    @Test
    void parseInfoMessage() {
        LogEntry entry = Parser.parseMessage("I 29 la la");
        assertThat(entry).isInstanceOf(LogMessage.class);
        LogMessage msg = (LogMessage) entry;
        assertThat(msg.type()).isEqualTo(LogMessage.Type.INFO);
        assertThat(msg.timestamp()).isEqualTo(29);
        assertThat(msg.content()).isEqualTo("la la");
        assertThat(msg.severity()).isEmpty();
    }

    @Test
    void parseWarningMessage() {
        LogEntry entry = Parser.parseMessage("W 10 be careful");
        assertThat(entry).isInstanceOf(LogMessage.class);
        LogMessage msg = (LogMessage) entry;
        assertThat(msg.type()).isEqualTo(LogMessage.Type.WARNING);
        assertThat(msg.timestamp()).isEqualTo(10);
        assertThat(msg.content()).isEqualTo("be careful");
        assertThat(msg.severity()).isEmpty();
    }

    @Test
    void parseErrorMessage() {
        LogEntry entry = Parser.parseMessage("E 70 3 some bad happened");
        assertThat(entry).isInstanceOf(LogMessage.class);
        LogMessage msg = (LogMessage) entry;
        assertThat(msg.type()).isEqualTo(LogMessage.Type.ERROR);
        assertThat(msg.severity()).contains(70);
        assertThat(msg.timestamp()).isEqualTo(3);
        assertThat(msg.content()).isEqualTo("some bad happened");
    }

    @Test
    void parseUnknownMessage() {
        LogEntry entry = Parser.parseMessage("This is not in the right format");
        assertThat(entry).isInstanceOf(Unknown.class);
        assertThat(((Unknown) entry).content()).isEqualTo("This is not in the right format");
    }

    @Test
    void inOrderSortsByTimestamp() {
        List<LogEntry> entries = List.of(
                Parser.parseMessage("I 29 la la"),
                Parser.parseMessage("E 2 562 help"),
                Parser.parseMessage("I 208 work"),
                Parser.parseMessage("W 20 mild warning"),
                Parser.parseMessage("E 70 3 some bad happened")
        );

        MessageTree tree = MessageTreeOps.build(entries);
        List<LogMessage> ordered = MessageTreeOps.inOrder(tree);
        assertThat(ordered.stream().map(LogMessage::timestamp).toList())
                .containsExactly(3, 20, 29, 208, 562);
    }

    @Test
    void whatWentWrongFiltersSevereErrorsInOrder() {
        List<String> inputLines = List.of(
                "I 29 la la",
                "E 2 562 help",
                "I 208 work",
                "W 20 mild warning",
                "E 70 3 some bad happened",
                "E 65 100 disk full",
                "E 30 99 minor error",
                "This is not in the right format"
        );
        List<LogEntry> entries = inputLines.stream().map(Parser::parseMessage).toList();

        List<String> result = LogAnalysis.whatWentWrong(entries);

        assertThat(result).containsExactly(
                "some bad happened", // timestamp 3
                "disk full"          // timestamp 100
        );
    }
}
