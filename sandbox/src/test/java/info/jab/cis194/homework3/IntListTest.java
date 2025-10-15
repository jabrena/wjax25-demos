package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Tests for IntList implementation
 */
public class IntListTest {
    
    @Test
    public void testEmptyList() {
        IntList empty = new IntList.Empty();
        assertEquals("Empty", empty.toString());
        assertTrue(empty instanceof IntList.Empty);
    }
    
    @Test
    public void testConsList() {
        IntList list = new IntList.Cons(1, new IntList.Cons(2, new IntList.Empty()));
        assertEquals("Cons(1, Cons(2, Empty))", list.toString());
        assertTrue(list instanceof IntList.Cons);
    }
    
    @Test
    public void testMapIntList() {
        IntList list = new IntList.Cons(1, new IntList.Cons(2, new IntList.Cons(3, new IntList.Empty())));
        
        // Test addOneToAll
        IntList result1 = IntList.addOneToAll(list);
        assertEquals("Cons(2, Cons(3, Cons(4, Empty)))", result1.toString());
        
        // Test absAll
        IntList negativeList = new IntList.Cons(-1, new IntList.Cons(2, new IntList.Cons(-3, new IntList.Empty())));
        IntList result2 = IntList.absAll(negativeList);
        assertEquals("Cons(1, Cons(2, Cons(3, Empty)))", result2.toString());
        
        // Test squareAll
        IntList result3 = IntList.squareAll(list);
        assertEquals("Cons(1, Cons(4, Cons(9, Empty)))", result3.toString());
    }
    
    @Test
    public void testFilterIntList() {
        IntList list = new IntList.Cons(-1, new IntList.Cons(2, new IntList.Cons(-3, new IntList.Cons(4, new IntList.Empty()))));
        
        // Test keepOnlyPositive
        IntList result1 = IntList.keepOnlyPositive(list);
        assertEquals("Cons(2, Cons(4, Empty))", result1.toString());
        
        // Test keepOnlyEven
        IntList result2 = IntList.keepOnlyEven(list);
        assertEquals("Cons(2, Cons(4, Empty))", result2.toString());
    }
    
    @Test
    public void testMapIntListWithCustomFunction() {
        IntList list = new IntList.Cons(1, new IntList.Cons(2, new IntList.Cons(3, new IntList.Empty())));
        
        // Test with custom function (multiply by 3)
        IntList result = IntList.mapIntList(x -> x * 3, list);
        assertEquals("Cons(3, Cons(6, Cons(9, Empty)))", result.toString());
    }
    
    @Test
    public void testFilterIntListWithCustomPredicate() {
        IntList list = new IntList.Cons(1, new IntList.Cons(2, new IntList.Cons(3, new IntList.Cons(4, new IntList.Empty()))));
        
        // Test with custom predicate (greater than 2)
        IntList result = IntList.filterIntList(x -> x > 2, list);
        assertEquals("Cons(3, Cons(4, Empty))", result.toString());
    }
    
    @Test
    public void testEmptyListOperations() {
        IntList empty = new IntList.Empty();
        
        // All operations on empty list should return empty list
        assertEquals("Empty", IntList.addOneToAll(empty).toString());
        assertEquals("Empty", IntList.absAll(empty).toString());
        assertEquals("Empty", IntList.squareAll(empty).toString());
        assertEquals("Empty", IntList.keepOnlyPositive(empty).toString());
        assertEquals("Empty", IntList.keepOnlyEven(empty).toString());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        IntList list1 = new IntList.Cons(1, new IntList.Cons(2, new IntList.Empty()));
        IntList list2 = new IntList.Cons(1, new IntList.Cons(2, new IntList.Empty()));
        IntList list3 = new IntList.Cons(1, new IntList.Cons(3, new IntList.Empty()));
        
        assertEquals(list1, list2);
        assertNotEquals(list1, list3);
        assertEquals(list1.hashCode(), list2.hashCode());
        
        IntList empty1 = new IntList.Empty();
        IntList empty2 = new IntList.Empty();
        assertEquals(empty1, empty2);
        assertEquals(empty1.hashCode(), empty2.hashCode());
    }
}