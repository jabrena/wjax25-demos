package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;

/**
 * Exercise 2: List operations and higher-order functions
 * 
 * This class implements list operations and functional programming concepts
 * similar to what would be taught in an introductory Haskell course.
 */
public class Exercise2 {

    /**
     * Sums all elements in a list of integers.
     * 
     * @param list the list of integers to sum
     * @return the sum of all elements, or 0 if the list is empty
     */
    public static int sumList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Multiplies all elements in a list of integers.
     * 
     * @param list the list of integers to multiply
     * @return the product of all elements, or 1 if the list is empty
     */
    public static int productList(List<Integer> list) {
        return list.stream().reduce(1, (a, b) -> a * b);
    }

    /**
     * Returns the length (number of elements) of a list.
     * 
     * @param list the list to measure
     * @return the number of elements in the list
     */
    public static int lengthList(List<?> list) {
        return list.size();
    }

    /**
     * Applies a function to each element of a list and returns a new list.
     * 
     * @param list the input list
     * @param function the function to apply to each element
     * @param <T> the type of input elements
     * @param <R> the type of output elements
     * @return a new list with the function applied to each element
     */
    public static <T, R> List<R> mapList(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(function.apply(element));
        }
        return result;
    }

    /**
     * Filters a list to keep only elements that satisfy a predicate.
     * 
     * @param list the input list
     * @param predicate the condition to test each element
     * @param <T> the type of elements
     * @return a new list containing only elements that satisfy the predicate
     */
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Folds a list from left to right using a binary operator and an initial value.
     * 
     * @param list the input list
     * @param initial the initial accumulator value
     * @param operator the binary operator to apply
     * @param <T> the type of list elements
     * @param <R> the type of the accumulator and result
     * @return the result of folding the list
     */
    public static <T, R> R foldLeft(List<T> list, R initial, java.util.function.BiFunction<R, T, R> operator) {
        R accumulator = initial;
        for (T element : list) {
            accumulator = operator.apply(accumulator, element);
        }
        return accumulator;
    }

    /**
     * Reverses a list.
     * 
     * @param list the input list
     * @param <T> the type of elements
     * @return a new list with elements in reverse order
     */
    public static <T> List<T> reverseList(List<T> list) {
        List<T> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}