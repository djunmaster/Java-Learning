package com.pilot.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperationMethod {

    public List<String> getStringList() {
        ArrayList<String> stringList = new ArrayList<>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a mockingbird");
        stringList.add("Gone with the wind");

        return stringList;
    }

    @Test
    public void terminalOperationAnyMatch() {
        Stream<String> stream = getStringList().stream();

        boolean match = stream.anyMatch(s -> s.startsWith("On"));
        System.out.println(match);
    }

    @Test
    public void terminalOperationAllMatch() {
        Stream<String> stream = getStringList().stream();
        Stream<String> stream2 = getStringList().stream();


        boolean match = stream.anyMatch(s -> s.contains("o"));
        boolean match2 = stream2.anyMatch(s -> s.contains("q"));
        System.out.println(match + " " + match2);
    }

    @Test
    public void terminalOperationNoneMatch() {
        Stream<String> stream = getStringList().stream();

        boolean match = stream.noneMatch(s -> s.contains("z"));
        System.out.println(match);
    }

    @Test
    public void terminalOperationCollect() {
        Stream<String> stream = getStringList().stream();

        List<String> stringsAsUppercaseList = stream
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(stringsAsUppercaseList);
    }

    @Test
    public void terminalOperationCount() {
        Stream<String> stream = getStringList().stream();

        long count = stream.count();
        System.out.println(count);
    }

    @Test
    public void terminalOperationFindAny() {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            Stream<String> stream = getStringList().stream();
            Optional<String> any = stream.parallel().findAny();

            if (any.isPresent()) {
                if (!countMap.containsKey(any.get())) {
                    countMap.put(any.get(), 1);
                } else {
                    countMap.put(any.get(), countMap.get(any.get()) + 1);
                }
            } else {
                System.out.println("not found");
            }
        }
        countMap.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    @Test
    public void terminalOperationFindFirst() {
        Stream<String> stream = getStringList().stream();
        Optional<String> first = stream.findFirst();

        first.ifPresent(System.out::println);
    }

    @Test
    public void terminalOperationMin() {
        Stream<String> stream = getStringList().stream();
        Optional<String> min = stream.min(String::compareTo);
        min.ifPresent(System.out::println);
    }

    @Test
    public void terminalOperationMax() {
        Stream<String> stream = getStringList().stream();
        Optional<String> max = stream.max(String::compareTo);
        max.ifPresent(System.out::println);
    }

    @Test
    public void terminalOperationReduce() {
        Stream<String> stream = getStringList().stream();

        Optional<String> reduce = stream.reduce((x1, x2) -> x1 + "123");
        reduce.ifPresent(System.out::println);
    }

    @Test
    public void terminalOperationToArray() {
        Stream<String> stream = getStringList().stream();

        Object[] array = stream.toArray();
        System.out.println(Arrays.toString(array));
    }
}
