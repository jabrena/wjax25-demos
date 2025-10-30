package info.jab.cis194.homework4;

import java.util.List;
import java.util.Objects;

public final class Exercise2 {

    private Exercise2() {}

    public static final class Tree<A> {
        private final boolean isLeaf;
        private final int height; // only meaningful for Node
        private final Tree<A> left;
        private final A value;
        private final Tree<A> right;

        private Tree() { // Leaf
            this.isLeaf = true;
            this.height = -1;
            this.left = null;
            this.value = null;
            this.right = null;
        }

        private Tree(int height, Tree<A> left, A value, Tree<A> right) {
            this.isLeaf = false;
            this.height = height;
            this.left = left;
            this.value = value;
            this.right = right;
        }

        public static <A> Tree<A> leaf() { return new Tree<>(); }

        public static <A> Tree<A> node(Tree<A> left, A value, Tree<A> right) {
            int h = 1 + Math.max(left.height(), right.height());
            return new Tree<>(h, left, value, right);
        }

        public boolean isLeaf() { return isLeaf; }
        public int height() { return isLeaf ? -1 : height; }
        public boolean isBalanced() {
            if (isLeaf) return true;
            int lh = left.height();
            int rh = right.height();
            return Math.abs(lh - rh) <= 1 && left.isBalanced() && right.isBalanced();
        }
    }

    public static <A> Tree<A> foldTree(List<A> values) {
        Objects.requireNonNull(values, "values");
        Tree<A> t = Tree.leaf();
        for (int i = values.size() - 1; i >= 0; i--) { // foldr-like
            t = insert(values.get(i), t);
        }
        return t;
    }

    private static <A> Tree<A> insert(A x, Tree<A> t) {
        if (t.isLeaf()) {
            return Tree.node(Tree.leaf(), x, Tree.leaf());
        }
        // Insert into the subtree with smaller height to keep balance
        int lh = t.left.height();
        int rh = t.right.height();
        if (lh <= rh) {
            Tree<A> newLeft = insert(x, t.left);
            return Tree.node(newLeft, t.value, t.right);
        } else {
            Tree<A> newRight = insert(x, t.right);
            return Tree.node(t.left, t.value, newRight);
        }
    }
}
