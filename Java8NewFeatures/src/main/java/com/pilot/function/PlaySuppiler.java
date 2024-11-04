package com.pilot.function;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PlaySuppiler {

    @Test
    public void getSupplierTest() {
        Supplier<String> greeting = () -> "Hello, World!";
        System.out.println(greeting.get());
    }

    @Test
    public void streamWithSupplierTest() {
        Supplier<Integer> randomSupplier = new Random()::nextInt;
        // 生成一个无限流并限制其大小为 5
        Stream<Integer> randomNumbers = Stream.generate(randomSupplier).limit(5);
        // 打印生成的随机数
        randomNumbers.forEach(System.out::println);
    }
}
