package com.pilot.function;

import org.junit.Test;

import java.util.function.Consumer;

public class PlayConsumer {
    @Test
    public void consumerAcceptTest() {
        Consumer<Integer> consumer = x -> {
            System.out.println("consumer accept:" + x);
        };
        consumer.accept(123);
    }

    @Test
    public void consumerAndThenTest() {
        Consumer<String> firstAction = (str) -> System.out.print("First action: " + str);
        Consumer<String> secondAction = (str) -> System.out.println(", Second action: " + str.toUpperCase());

        // 创建一个组合的 Consumer
        Consumer<String> combinedAction = firstAction.andThen(secondAction);

        // 调用组合的 Consumer
        combinedAction.accept("Hello, World!");
    }
}
