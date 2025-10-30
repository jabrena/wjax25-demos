package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

public final class MessageTreeOps {
    private MessageTreeOps() {}

    public static MessageTree insert(LogMessage message, MessageTree tree) {
        if (tree == null || tree.isLeaf()) {
            return MessageTree.node(MessageTree.leaf(), message, MessageTree.leaf());
        }
        if (message.timestamp() <= tree.message.timestamp()) {
            return MessageTree.node(insert(message, tree.left), tree.message, tree.right);
        } else {
            return MessageTree.node(tree.left, tree.message, insert(message, tree.right));
        }
    }

    public static MessageTree build(List<LogEntry> entries) {
        MessageTree tree = MessageTree.leaf();
        for (LogEntry entry : entries) {
            if (entry instanceof LogMessage msg) {
                tree = insert(msg, tree);
            }
        }
        return tree;
    }

    public static List<LogMessage> inOrder(MessageTree tree) {
        List<LogMessage> result = new ArrayList<>();
        traverse(tree, result);
        return result;
    }

    private static void traverse(MessageTree tree, List<LogMessage> acc) {
        if (tree == null || tree.isLeaf()) return;
        traverse(tree.left, acc);
        acc.add(tree.message);
        traverse(tree.right, acc);
    }
}
