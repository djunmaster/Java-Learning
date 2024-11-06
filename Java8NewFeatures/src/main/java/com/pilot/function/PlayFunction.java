package com.pilot.function;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlayFunction {
    @Test
    public void functionApplyTest() {
        // 使用一个函数式接口，将字符串转换为大写
        Function<String, String> strUpperCaseFunction = String::toUpperCase;
        String hello = strUpperCaseFunction.apply("hello");
        System.out.println(hello);

        Function<String, Map<Character, Integer>> countCharNumberFunction = str -> {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            return map;
        };
        countCharNumberFunction.apply("hello").forEach((k, v) -> System.out.println(k + ":" + v));
    }


    @Test
    public void functionAddTenTest() {
        // 使用两个函数式接口，分别是获取字符串长度，然后乘以2
        Function<String, Integer> lengthFunction = String::length;
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Function<String, Integer> function = lengthFunction.andThen(doubleFunction);
        Integer doubleLength = function.apply("www.wdbyte.com");
        System.out.println(doubleLength);
    }

    @Test
    public void functionIdentityTest() {
        Function<String, String> identity = Function.identity();
        System.out.println(identity.apply("hello"));
    }

    private void processFunction(Function<String, String> function, String inputString) {
        String string = function.apply(inputString);
        System.out.println(string.length());
    }

    @Test
    // 定义一个方法，接受一个字符串和一个 Function<String, String> 类型的参数，然后返回处理后的字符串
    public void processString() {
        processFunction(String::trim, " hello, world! ");
        processFunction(s -> s.substring(0, 4), " hello, world! ");
    }

    private List<String> filterFunction(List<String> words, Predicate<String> condition) {
        ArrayList<String> list = new ArrayList<>();
        words.forEach(s -> {
            // 对字符串添加一个条件，判断是否满足
            if (condition.test(s)) {
                list.add(s);
            }
        });
        return list;
    }

    @Test
    public void filterList() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println(filterFunction(words, s -> s.length() > 4));
    }
}
