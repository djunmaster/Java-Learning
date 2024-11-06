package com.pilot.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Data
@AllArgsConstructor
class Employee {
    private String name;
    private int age;
}

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

    private void consumerFunction(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }

    @Test
    public void consumerMessage() {
        List<String> messageList = Arrays.asList("hello", "com back", "morning", "bye bye");
        consumerFunction(messageList, System.out::println);
        System.out.println();
        consumerFunction(messageList, s -> System.out.println("warning " + s));
    }

    private List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Employee("Alice", 22),
                new Employee("Bob", 20),
                new Employee("Charlie", 21),
                new Employee("David", 20)
        );
    }


    private void consumerEmployFunction(Consumer<Employee> consumer, Employee employee) {
        consumer.accept(employee);
    }

    @Test
    public void consumerObject() {
        List<Employee> employeeList = getEmployeeList();
        employeeList.forEach(employee -> {
            consumerEmployFunction(e -> {
                e.setAge(18);
            }, employee);
        });
        System.out.println(employeeList);
    }

    @Test
    public void consumerAndThenFunction() {
        Consumer<Object> consumer = System.out::println;
        Consumer<Object> consumer1 = n -> System.out.println(n + "-F2");
        consumer.andThen(consumer1).accept(666);
        System.out.println();
        consumer1.andThen(consumer1).andThen(consumer1).accept(555);
    }
}
