package info.jab.cis194.homework3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Maybe implementation
 */
public class MaybeTest {
    
    @Test
    public void testNothing() {
        Maybe<String> nothing = new Maybe.Nothing<>();
        assertEquals("Nothing", nothing.toString());
        assertTrue(nothing instanceof Maybe.Nothing);
        assertTrue(Maybe.isNothing(nothing));
        assertFalse(Maybe.isJust(nothing));
    }
    
    @Test
    public void testJust() {
        Maybe<String> just = new Maybe.Just<>("hello");
        assertEquals("Just(hello)", just.toString());
        assertTrue(just instanceof Maybe.Just);
        assertTrue(Maybe.isJust(just));
        assertFalse(Maybe.isNothing(just));
    }
    
    @Test
    public void testSafeHead() {
        // Test with non-empty list
        List<String> list = new List.C<>("first", new List.C<>("second", new List.E<>()));
        Maybe<String> head = Maybe.safeHead(list);
        assertTrue(Maybe.isJust(head));
        assertEquals("first", ((Maybe.Just<String>) head).getValue());
        
        // Test with empty list
        List<String> empty = new List.E<>();
        Maybe<String> emptyHead = Maybe.safeHead(empty);
        assertTrue(Maybe.isNothing(emptyHead));
    }
    
    @Test
    public void testSafeTail() {
        // Test with non-empty list
        List<String> list = new List.C<>("first", new List.C<>("second", new List.E<>()));
        Maybe<List<String>> tail = Maybe.safeTail(list);
        assertTrue(Maybe.isJust(tail));
        assertEquals("C(second, E)", ((Maybe.Just<List<String>>) tail).getValue().toString());
        
        // Test with empty list
        List<String> empty = new List.E<>();
        Maybe<List<String>> emptyTail = Maybe.safeTail(empty);
        assertTrue(Maybe.isNothing(emptyTail));
    }
    
    @Test
    public void testMapMaybe() {
        Maybe<Integer> just = new Maybe.Just<>(5);
        Maybe<String> mapped = Maybe.mapMaybe(x -> "num" + x, just);
        assertTrue(Maybe.isJust(mapped));
        assertEquals("num5", ((Maybe.Just<String>) mapped).getValue());
        
        Maybe<Integer> nothing = new Maybe.Nothing<>();
        Maybe<String> mappedNothing = Maybe.mapMaybe(x -> "num" + x, nothing);
        assertTrue(Maybe.isNothing(mappedNothing));
    }
    
    @Test
    public void testFromMaybe() {
        Maybe<String> just = new Maybe.Just<>("hello");
        assertEquals("hello", Maybe.fromMaybe("default", just));
        
        Maybe<String> nothing = new Maybe.Nothing<>();
        assertEquals("default", Maybe.fromMaybe("default", nothing));
    }
    
    @Test
    public void testEqualsAndHashCode() {
        Maybe<String> just1 = new Maybe.Just<>("hello");
        Maybe<String> just2 = new Maybe.Just<>("hello");
        Maybe<String> just3 = new Maybe.Just<>("world");
        
        assertEquals(just1, just2);
        assertNotEquals(just1, just3);
        assertEquals(just1.hashCode(), just2.hashCode());
        
        Maybe<String> nothing1 = new Maybe.Nothing<>();
        Maybe<String> nothing2 = new Maybe.Nothing<>();
        assertEquals(nothing1, nothing2);
        assertEquals(nothing1.hashCode(), nothing2.hashCode());
    }
    
    @Test
    public void testDifferentTypes() {
        // Test with different types to ensure polymorphism works
        Maybe<Integer> intMaybe = new Maybe.Just<>(42);
        Maybe<String> stringMaybe = Maybe.mapMaybe(x -> "The answer is " + x, intMaybe);
        assertTrue(Maybe.isJust(stringMaybe));
        assertEquals("The answer is 42", ((Maybe.Just<String>) stringMaybe).getValue());
        
        Maybe<Double> doubleMaybe = new Maybe.Just<>(3.14);
        Maybe<Integer> intFromDouble = Maybe.mapMaybe(x -> (int) (x * 2), doubleMaybe);
        assertTrue(Maybe.isJust(intFromDouble));
        assertEquals(6, ((Maybe.Just<Integer>) intFromDouble).getValue().intValue());
    }
    
    @Test
    public void testSafeHeadWithDifferentTypes() {
        List<Integer> intList = new List.C<>(1, new List.C<>(2, new List.E<>()));
        Maybe<Integer> intHead = Maybe.safeHead(intList);
        assertTrue(Maybe.isJust(intHead));
        assertEquals(1, ((Maybe.Just<Integer>) intHead).getValue().intValue());
        
        List<Boolean> boolList = new List.C<>(true, new List.C<>(false, new List.E<>()));
        Maybe<Boolean> boolHead = Maybe.safeHead(boolList);
        assertTrue(Maybe.isJust(boolHead));
        assertTrue(((Maybe.Just<Boolean>) boolHead).getValue());
    }
}