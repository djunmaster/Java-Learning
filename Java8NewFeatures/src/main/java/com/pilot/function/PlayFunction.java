package com.pilot.function;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

}
