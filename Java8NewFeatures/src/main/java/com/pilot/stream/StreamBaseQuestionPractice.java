package com.pilot.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBaseQuestionPractice {
    @Test
    // 找出整数列表中大于5的最小值
    public void findMinValueGreaterThanFive() {
        List<Integer> list = Arrays.asList(3, 7, 8, 9, 2, 5, 1, 4);
        list.stream().filter(n -> n > 5).min((a,b) -> a - b).ifPresent(System.out::println);
        list.stream().filter(n -> n > 5).min(Comparator.comparingInt(a -> a)).ifPresent(System.out::println);
        list.stream().filter(n -> n > 5).min((a,b) -> b -a).ifPresent(System.out::println);
    }

    @Test
    // 检查整数列表中是否存在至少一个数字大于5
    public void hasNumberGreaterThanTen() {
        List<Integer> list = Arrays.asList(3, 7, 8, 9, 2, 5, 1, 4);
        boolean match = list.stream().anyMatch(n -> n > 5);
        System.out.println(match);
    }

    @Test
    // 检查整数列表中是否包含连续的数字
    public void hasConsecutiveNumbers() {
        List<Integer> list = Arrays.asList(3, 7, 6, 8, 9, 2, 5, 1, 4);
        List<Integer> integerList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(isConsecutiveArray(integerList));
    }

    private Boolean isConsecutiveArray(List<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            if (integerList.get(i) - integerList.get(i - 1) != 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    // 从字符串列表中找出最长的字符串
    public void findLongestString() {
        List<String> strings = Arrays.asList("hello", "world2222", "stream22", "api", "java");
        // plan1
        strings.stream().max((a, b) -> a.length() - b.length()).ifPresent(System.out::println);
        // plan2
        strings.stream().max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
    }
}
