package info.jab.cis194.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Exercise 4: Anonymous Functions and Lambda Expressions
 * 
 * This class demonstrates the use of anonymous functions and lambda expressions
 * to create concise, functional code patterns. Lambda expressions are a key
 * feature of functional programming in Java.
 */
public class Exercise4 {

    /**
     * Creates an anonymous function that squares its input.
     * 
     * @return a function that squares integers
     */
    public static Function<Integer, Integer> createSquareFunction() {
        return x -> x * x;
    }

    /**
     * Creates an anonymous predicate that tests if a number is even.
     * 
     * @return a predicate that tests for even numbers
     */
    public static Predicate<Integer> createIsEvenPredicate() {
        return x -> x % 2 == 0;
    }

    /**
     * Creates an anonymous binary operator that adds two integers.
     * 
     * @return a binary operator that adds integers
     */
    public static BinaryOperator<Integer> createAddOperator() {
        return (a, b) -> a + b;
    }

    /**
     * Maps a list of strings to their lengths using method references.
     * 
     * @param words the list of strings
     * @return a list of string lengths
     */
    public static List<Integer> mapWithMethodReference(List<String> words) {
        return words.stream()
                   .map(String::length)
                   .collect(Collectors.toList());
    }

    /**
     * Maps a list of strings to integers using constructor references.
     * 
     * @param numbers the list of string numbers
     * @return a list of integers
     */
    public static List<Integer> mapWithConstructorReference(List<String> numbers) {
        return numbers.stream()
                     .map(Integer::new)
                     .collect(Collectors.toList());
    }

    /**
     * Creates a multiplier function that captures a variable from its scope.
     * 
     * @param multiplier the value to multiply by
     * @return a function that multiplies by the captured value
     */
    public static Function<Integer, Integer> createMultiplier(int multiplier) {
        return x -> x * multiplier;
    }

    /**
     * Filters a list of strings by length using a lambda expression.
     * 
     * @param words the list of strings
     * @param minLength the minimum length to keep
     * @return a list of strings with length >= minLength
     */
    public static List<String> filterByLength(List<String> words, int minLength) {
        return words.stream()
                   .filter(word -> word.length() >= minLength)
                   .collect(Collectors.toList());
    }

    /**
     * Processes a list of numbers with complex lambda logic.
     * Keeps only even numbers and squares them.
     * 
     * @param numbers the list of numbers
     * @return a list of squares of even numbers
     */
    public static List<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
                     .filter(x -> x % 2 == 0)  // Keep only even numbers
                     .map(x -> x * x)          // Square them
                     .collect(Collectors.toList());
    }

    /**
     * Parses a list of strings to integers, safely handling invalid input.
     * 
     * @param numbers the list of string numbers
     * @return a list of successfully parsed integers
     */
    public static List<Integer> parseNumbersSafely(List<String> numbers) {
        return numbers.stream()
                     .filter(s -> {
                         try {
                             Integer.parseInt(s);
                             return true;
                         } catch (NumberFormatException e) {
                             return false;
                         }
                     })
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    /**
     * Creates an adder function that returns another function.
     * This demonstrates higher-order functions with lambda expressions.
     * 
     * @return a function that takes a number and returns an adder function
     */
    public static Function<Integer, Function<Integer, Integer>> createAdder() {
        return a -> b -> a + b;
    }

    /**
     * Classifies numbers as "even" or "odd" using lambda expressions.
     * 
     * @param numbers the list of numbers
     * @return a list of classifications
     */
    public static List<String> classifyNumbers(List<Integer> numbers) {
        return numbers.stream()
                     .map(x -> x % 2 == 0 ? "even" : "odd")
                     .collect(Collectors.toList());
    }

    /**
     * Processes words by converting them to uppercase using lambda expressions.
     * 
     * @param words the list of words
     * @return a list of uppercase words
     */
    public static List<String> processWords(List<String> words) {
        return words.stream()
                   .map(String::toUpperCase)
                   .collect(Collectors.toList());
    }

    /**
     * Creates a function that applies a given function multiple times.
     * 
     * @param f the function to apply
     * @param times the number of times to apply it
     * @return a function that applies f multiple times
     */
    public static <T> Function<T, T> repeat(Function<T, T> f, int times) {
        return x -> {
            T result = x;
            for (int i = 0; i < times; i++) {
                result = f.apply(result);
            }
            return result;
        };
    }

    /**
     * Creates a function that chains multiple functions together.
     * 
     * @param functions the functions to chain
     * @return a function that applies all functions in sequence
     */
    @SafeVarargs
    public static <T> Function<T, T> chain(Function<T, T>... functions) {
        return x -> {
            T result = x;
            for (Function<T, T> f : functions) {
                result = f.apply(result);
            }
            return result;
        };
    }

    /**
     * Creates a memoized version of a function using lambda expressions.
     * This is a simple implementation without thread safety.
     * 
     * @param f the function to memoize
     * @return a memoized version of the function
     */
    public static <T, R> Function<T, R> memoize(Function<T, R> f) {
        return new Function<T, R>() {
            private final java.util.Map<T, R> cache = new java.util.HashMap<>();
            
            @Override
            public R apply(T t) {
                return cache.computeIfAbsent(t, f);
            }
        };
    }
}