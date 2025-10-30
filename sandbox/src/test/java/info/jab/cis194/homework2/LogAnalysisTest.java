package info.jab.cis194.homework2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LogAnalysisTest {

    @Test
    void parseMessage_parsesKnownFormats() {
        Entry e1 = LogParser.parseMessage("I 29 la la");
        Entry e2 = LogParser.parseMessage("E 2 562 help help");
        Entry e3 = LogParser.parseMessage("W 1 world");
        Entry e4 = LogParser.parseMessage("The quick brown fox");

        assertThat(e1).isInstanceOf(LogMessage.class);
        assertThat(((LogMessage) e1).type()).isEqualTo(MessageType.INFO);
        assertThat(((LogMessage) e1).timestamp()).isEqualTo(29);
        assertThat(((LogMessage) e1).message()).isEqualTo("la la");

        assertThat(e2).isInstanceOf(LogMessage.class);
        assertThat(((LogMessage) e2).type()).isEqualTo(MessageType.error(2));
        assertThat(((LogMessage) e2).timestamp()).isEqualTo(562);
        assertThat(((LogMessage) e2).message()).isEqualTo("help help");

        assertThat(e3).isInstanceOf(LogMessage.class);
        assertThat(((LogMessage) e3).type()).isEqualTo(MessageType.WARNING);
        assertThat(((LogMessage) e3).timestamp()).isEqualTo(1);
        assertThat(((LogMessage) e3).message()).isEqualTo("world");

        assertThat(e4).isInstanceOf(Unknown.class);
        assertThat(((Unknown) e4).raw()).isEqualTo("The quick brown fox");
    }

    @Test
    void parse_parsesMultipleLines() {
        String input = String.join("\n",
            "I 6 Completed armadillo processing",
            "I 1 Nothing to report",
            "E 99 10 Flange failed!",
            "I 4 Everything normal",
            "I 11 Initiating self-destruct sequence",
            "E 70 3 Way too many pickles",
            "E 65 8 Bad pickle-flange interaction detected",
            "W 5 Flange is due for a check-up",
            "I 7 Out for lunch, back in two time steps",
            "E 20 2 Too many pickles",
            "I 9 Back from lunch");

        List<Entry> entries = LogParser.parse(input);
        assertThat(entries).hasSize(11);
        assertThat(entries.get(0)).isInstanceOf(LogMessage.class);
    }

    @Test
    void buildTreeAndInOrder_sortsByTimestamp() {
        List<Entry> entries = LogParser.parse(String.join("\n",
            "I 6 Completed armadillo processing",
            "I 1 Nothing to report",
            "E 99 10 Flange failed!",
            "I 4 Everything normal",
            "I 11 Initiating self-destruct sequence",
            "E 70 3 Way too many pickles",
            "E 65 8 Bad pickle-flange interaction detected",
            "W 5 Flange is due for a check-up",
            "I 7 Out for lunch, back in two time steps",
            "E 20 2 Too many pickles",
            "I 9 Back from lunch"));

        MessageTree tree = MessageTree.build(entries);
        List<LogMessage> ordered = tree.inOrder();
        assertThat(ordered.stream().map(LogMessage::timestamp).toList())
            .containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    }

    @Test
    void whatWentWrong_filtersSevereErrorsInTimeOrder() {
        List<Entry> entries = LogParser.parse(String.join("\n",
            "I 6 Completed armadillo processing",
            "I 1 Nothing to report",
            "E 99 10 Flange failed!",
            "I 4 Everything normal",
            "I 11 Initiating self-destruct sequence",
            "E 70 3 Way too many pickles",
            "E 65 8 Bad pickle-flange interaction detected",
            "W 5 Flange is due for a check-up",
            "I 7 Out for lunch, back in two time steps",
            "E 20 2 Too many pickles",
            "I 9 Back from lunch"));

        List<String> msgs = LogAnalysis.whatWentWrong(entries);
        assertThat(msgs)
            .containsExactly(
                "Way too many pickles", // E 70 3
                "Bad pickle-flange interaction detected", // E 65 8
                "Flange failed!" // E 99 10
            );
    }
}
