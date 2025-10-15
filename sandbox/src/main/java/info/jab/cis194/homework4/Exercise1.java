package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

/**
 * Exercise 1: Basic Higher-Order Functions
 * 
 * This class implements fundamental higher-order functions commonly used
 * in functional programming: map, filter, and fold operations.
 * 
 * These functions demonstrate the power of treating functions as first-class
 * values and enable elegant, composable code patterns.
 */
public class Exercise1 {

    /**
     * Applies a function to each element of a list, returning a new list
     * with the transformed elements.
     * 
     * @param <A> the type of elements in the input list
     * @param <B> the type of elements in the output list
     * @param f the function to apply to each element
     * @param list the input list
     * @return a new list with elements transformed by the function
     */
    public static <A, B> List<B> map(Function<A, B> f, List<A> list) {
        List<B> result = new ArrayList<>();
        for (A element : list) {
            result.add(f.apply(element));
        }
        return result;
    }

    /**
     * Filters a list by keeping only elements that satisfy a predicate.
     * 
     * @param <A> the type of elements in the list
     * @param predicate the condition to test each element
     * @param list the input list
     * @return a new list containing only elements that satisfy the predicate
     */
    public static <A> List<A> filter(Predicate<A> predicate, List<A> list) {
        List<A> result = new ArrayList<>();
        for (A element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Folds a list from left to right using a binary operator and an initial value.
     * This is equivalent to: initial op list[0] op list[1] op ... op list[n-1]
     * 
     * @param <A> the type of elements in the list
     * @param <B> the type of the accumulator and result
     * @param op the binary operator to combine elements
     * @param initial the initial accumulator value
     * @param list the input list
     * @return the result of folding the list from left to right
     */
    public static <A, B> B foldLeft(BinaryOperator<B> op, B initial, List<A> list) {
        B accumulator = initial;
        for (A element : list) {
            // Note: This is a simplified version. In a real implementation,
            // we'd need a BiFunction<B, A, B> to handle different types
            // For this exercise, we'll assume A and B are the same type
            @SuppressWarnings("unchecked")
            B elementAsB = (B) element;
            accumulator = op.apply(accumulator, elementAsB);
        }
        return accumulator;
    }

    /**
     * Folds a list from right to left using a binary operator and an initial value.
     * This is equivalent to: list[0] op (list[1] op (... op (list[n-1] op initial)))
     * 
     * @param <A> the type of elements in the list
     * @param <B> the type of the accumulator and result
     * @param op the binary operator to combine elements
     * @param initial the initial accumulator value
     * @param list the input list
     * @return the result of folding the list from right to left
     */
    public static <A, B> B foldRight(BinaryOperator<B> op, B initial, List<A> list) {
        if (list.isEmpty()) {
            return initial;
        }
        
        // For right fold, we need to process from right to left
        // We'll use recursion to achieve this
        return foldRightHelper(op, initial, list, 0);
    }

    /**
     * Helper method for foldRight that handles the recursive processing.
     */
    private static <A, B> B foldRightHelper(BinaryOperator<B> op, B initial, List<A> list, int index) {
        if (index >= list.size()) {
            return initial;
        }
        
        A current = list.get(index);
        B rest = foldRightHelper(op, initial, list, index + 1);
        
        @SuppressWarnings("unchecked")
        B currentAsB = (B) current;
        return op.apply(currentAsB, rest);
    }
}