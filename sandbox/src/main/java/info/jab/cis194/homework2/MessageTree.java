package info.jab.cis194.homework2;

import java.util.ArrayList;
import java.util.List;

public final class MessageTree {

    private static final class Node {
        final LogMessage value;
        Node left;
        Node right;
        Node(LogMessage value) { this.value = value; }
    }

    private Node root;

    public MessageTree() {}

    public static MessageTree build(List<Entry> entries) {
        MessageTree tree = new MessageTree();
        if (entries == null) return tree;
        for (Entry e : entries) {
            if (e instanceof LogMessage lm) {
                tree.insert(lm);
            }
        }
        return tree;
    }

    public void insert(LogMessage msg) {
        if (root == null) {
            root = new Node(msg);
            return;
        }
        Node cur = root;
        while (true) {
            if (msg.timestamp() <= cur.value.timestamp()) {
                if (cur.left == null) { cur.left = new Node(msg); return; }
                cur = cur.left;
            } else {
                if (cur.right == null) { cur.right = new Node(msg); return; }
                cur = cur.right;
            }
        }
    }

    public List<LogMessage> inOrder() {
        List<LogMessage> out = new ArrayList<>();
        inOrder(root, out);
        return out;
    }

    private void inOrder(Node n, List<LogMessage> out) {
        if (n == null) return;
        inOrder(n.left, out);
        out.add(n.value);
        inOrder(n.right, out);
    }
}
