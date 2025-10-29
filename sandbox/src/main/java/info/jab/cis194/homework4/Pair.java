package info.jab.cis194.homework4;

/**
 * Simple pair data structure
 */
public record Pair<A, B>(A first, B second) {
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return java.util.Objects.equals(first, pair.first) && 
               java.util.Objects.equals(second, pair.second);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(first, second);
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}