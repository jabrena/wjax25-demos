package info.jab.cis194.homework1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Exercise 3: Advanced functional programming concepts
 * 
 * This exercise covers advanced functional programming concepts like
 * function composition, currying, and monadic operations.
 */
public class Exercise3Test {

    @Test
    public void testCompose() {
        // Test function composition
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> composed = Exercise3.compose(addOne, multiplyByTwo);
        
        assertThat(composed.apply(5)).isEqualTo(11); // (5 * 2) + 1 = 11
        assertThat(composed.apply(0)).isEqualTo(1);  // (0 * 2) + 1 = 1
        assertThat(composed.apply(-3)).isEqualTo(-5); // (-3 * 2) + 1 = -5
    }

    @Test
    public void testCurry() {
        // Test currying of a two-argument function
        java.util.function.BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = Exercise3.curry(add);
        
        assertThat(curriedAdd.apply(5).apply(3)).isEqualTo(8);
        assertThat(curriedAdd.apply(0).apply(10)).isEqualTo(10);
        assertThat(curriedAdd.apply(-2).apply(7)).isEqualTo(5);
    }

    @Test
    public void testUncurry() {
        // Test uncurrying of a curried function
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;
        java.util.function.BiFunction<Integer, Integer, Integer> uncurriedAdd = Exercise3.uncurry(curriedAdd);
        
        assertThat(uncurriedAdd.apply(5, 3)).isEqualTo(8);
        assertThat(uncurriedAdd.apply(0, 10)).isEqualTo(10);
        assertThat(uncurriedAdd.apply(-2, 7)).isEqualTo(5);
    }

    @Test
    public void testMaybeMap() {
        // Test Maybe monad map operation
        Exercise3.Maybe<Integer> justFive = Exercise3.Maybe.just(5);
        Exercise3.Maybe<Integer> nothing = Exercise3.Maybe.nothing();
        
        Exercise3.Maybe<Integer> doubled = Exercise3.maybeMap(justFive, x -> x * 2);
        assertThat(doubled.isJust()).isTrue();
        assertThat(doubled.getValue()).isEqualTo(10);
        
        Exercise3.Maybe<Integer> doubledNothing = Exercise3.maybeMap(nothing, x -> x * 2);
        assertThat(doubledNothing.isNothing()).isTrue();
    }

    @Test
    public void testMaybeFlatMap() {
        // Test Maybe monad flatMap operation
        Exercise3.Maybe<Integer> justFive = Exercise3.Maybe.just(5);
        Exercise3.Maybe<Integer> nothing = Exercise3.Maybe.nothing();
        
        Function<Integer, Exercise3.Maybe<Integer>> safeDivide = x -> x != 0 ? Exercise3.Maybe.just(10 / x) : Exercise3.Maybe.nothing();
        
        Exercise3.Maybe<Integer> result = Exercise3.maybeFlatMap(justFive, safeDivide);
        assertThat(result.isJust()).isTrue();
        assertThat(result.getValue()).isEqualTo(2);
        
        Exercise3.Maybe<Integer> resultNothing = Exercise3.maybeFlatMap(nothing, safeDivide);
        assertThat(resultNothing.isNothing()).isTrue();
    }

    @Test
    public void testMaybeFromNullable() {
        // Test creating Maybe from nullable value
        Exercise3.Maybe<String> justHello = Exercise3.Maybe.fromNullable("hello");
        assertThat(justHello.isJust()).isTrue();
        assertThat(justHello.getValue()).isEqualTo("hello");
        
        Exercise3.Maybe<String> nothing = Exercise3.Maybe.fromNullable(null);
        assertThat(nothing.isNothing()).isTrue();
    }

    @Test
    public void testMaybeOrElse() {
        // Test Maybe orElse operation
        Exercise3.Maybe<Integer> justFive = Exercise3.Maybe.just(5);
        Exercise3.Maybe<Integer> nothing = Exercise3.Maybe.nothing();
        
        assertThat(Exercise3.maybeOrElse(justFive, 0)).isEqualTo(5);
        assertThat(Exercise3.maybeOrElse(nothing, 0)).isEqualTo(0);
    }

    @Test
    public void testZipWith() {
        // Test zipWith operation on lists
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40);
        List<Integer> result = Exercise3.zipWith(list1, list2, (x, y) -> x + y);
        
        assertThat(result).containsExactly(11, 22, 33, 44);
        
        List<String> strings1 = Arrays.asList("hello", "world");
        List<String> strings2 = Arrays.asList("java", "haskell");
        List<String> combined = Exercise3.zipWith(strings1, strings2, (s1, s2) -> s1 + " " + s2);
        
        assertThat(combined).containsExactly("hello java", "world haskell");
    }
}