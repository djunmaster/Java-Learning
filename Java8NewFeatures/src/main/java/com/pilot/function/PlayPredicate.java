package com.pilot.function;

import org.junit.Test;

import java.util.function.Predicate;

public class PlayPredicate {
    @Test
    public void predicateTestTest() {
        // 输入参数为整型，返回值为布尔型
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
    }

    @Test
    public void predicateAndTest() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;

        Predicate<Integer> isPositiveAndEven = isEven.and(isPositive);
        System.out.println(isPositiveAndEven.test(4)); // 输出: true
        System.out.println(isPositiveAndEven.test(-4)); // 输出: false
    }

    @Test
    public void predicateOrTest() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isNegative = x -> x < 0;

        Predicate<Integer> isEvenOrNegative = isEven.or(isNegative);
        System.out.println(isEvenOrNegative.test(4)); // 输出: true
        System.out.println(isEvenOrNegative.test(-3)); // 输出: true
    }

    @Test
    public void predicateNegateTest() {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isNotEven = isEven.negate();

        System.out.println(isNotEven.test(4)); // 输出: false
        System.out.println(isNotEven.test(3)); // 输出: true
    }

    @Test
    public void predicateIsEqualTest() {
        Predicate<String> isEqualToHello = Predicate.isEqual("Hello");

        System.out.println(isEqualToHello.test("Hello")); // 输出: true
        System.out.println(isEqualToHello.test("World")); // 输出: false
    }
}
