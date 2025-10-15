package info.jab.cis194.homework3;

/**
 * IntList represents a list of integers using a recursive data structure.
 * This is the Java equivalent of the Haskell IntList type from the lecture.
 */
public abstract class IntList {
    
    /**
     * Empty list constructor
     */
    public static class Empty extends IntList {
        @Override
        public String toString() {
            return "Empty";
        }
        
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Empty;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
    }
    
    /**
     * Non-empty list constructor with head and tail
     */
    public static class Cons extends IntList {
        private final int head;
        private final IntList tail;
        
        public Cons(int head, IntList tail) {
            this.head = head;
            this.tail = tail;
        }
        
        public int getHead() {
            return head;
        }
        
        public IntList getTail() {
            return tail;
        }
        
        @Override
        public String toString() {
            return "Cons(" + head + ", " + tail + ")";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Cons)) return false;
            Cons other = (Cons) obj;
            return head == other.head && tail.equals(other.tail);
        }
        
        @Override
        public int hashCode() {
            return Integer.hashCode(head) + 31 * tail.hashCode();
        }
    }
    
    /**
     * Apply a function to every element in the list
     */
    public static IntList mapIntList(java.util.function.IntUnaryOperator f, IntList list) {
        if (list instanceof Empty) {
            return new Empty();
        } else if (list instanceof Cons) {
            Cons cons = (Cons) list;
            return new Cons(f.applyAsInt(cons.getHead()), mapIntList(f, cons.getTail()));
        }
        throw new IllegalArgumentException("Unknown IntList type");
    }
    
    /**
     * Filter elements based on a predicate
     */
    public static IntList filterIntList(java.util.function.IntPredicate p, IntList list) {
        if (list instanceof Empty) {
            return new Empty();
        } else if (list instanceof Cons) {
            Cons cons = (Cons) list;
            if (p.test(cons.getHead())) {
                return new Cons(cons.getHead(), filterIntList(p, cons.getTail()));
            } else {
                return filterIntList(p, cons.getTail());
            }
        }
        throw new IllegalArgumentException("Unknown IntList type");
    }
    
    /**
     * Add one to all elements
     */
    public static IntList addOneToAll(IntList list) {
        return mapIntList(x -> x + 1, list);
    }
    
    /**
     * Take absolute value of all elements
     */
    public static IntList absAll(IntList list) {
        return mapIntList(Math::abs, list);
    }
    
    /**
     * Square all elements
     */
    public static IntList squareAll(IntList list) {
        return mapIntList(x -> x * x, list);
    }
    
    /**
     * Keep only positive numbers
     */
    public static IntList keepOnlyPositive(IntList list) {
        return filterIntList(x -> x > 0, list);
    }
    
    /**
     * Keep only even numbers
     */
    public static IntList keepOnlyEven(IntList list) {
        return filterIntList(x -> x % 2 == 0, list);
    }
}