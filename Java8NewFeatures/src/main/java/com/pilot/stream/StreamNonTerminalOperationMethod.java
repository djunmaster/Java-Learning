package com.pilot.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamNonTerminalOperationMethod {

    private List<String> getStringList() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        return stringList;
    }

    @Test
    public void nonTerminalOperationExample() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        Stream<String> stringStream = stream.map(s -> s = s + "666");
        Stream<String> stringStream2 = stringStream.map(String::toLowerCase);

        // 调用链中间的流，不能抽离单独使用（即不能使用stringStream进行数据处理操作）
        stringStream2.forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationFilter() {
        // 获取流对象
        Stream<String> stream = getStringList().stream();

        // 使用filter方法过滤长度大于等于4的字符串
        stream.filter(s -> {
            return s.length() >= 4;
        }).forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationMap() {
        // 获取流对象
        Stream<String> stream = getStringList().stream();

        stream.map(s -> {
            s = s.toLowerCase();
            return s.substring(1, 3);
        }).forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationFlatMap() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a mockingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return Arrays.stream(split);
        }).forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationDistinct() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("one");

        Stream<String> stringStream = arrayList.stream();

        stringStream.distinct().forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationLimit() {
        Stream<String> stringStream = getStringList().stream();

        stringStream.limit(2).forEach(System.out::println);
    }

    @Test
    public void nonTerminalOperationPeek() {

        Stream<String> stream = getStringList().stream();

        stream.peek(name -> System.out.println("Before processing: " + name))
                .map(String::toLowerCase)
                .peek(name -> System.out.println("After mapping: " + name))
                .forEach(System.out::println);
    }
}


