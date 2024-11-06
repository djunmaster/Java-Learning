package com.pilot.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBaseQuestionPractice {
    @Test
    // 1. 计算一个list的总和
    public void calculateIntegerListSum() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        // plan1
        Integer integer = list.stream().reduce(-1, Integer::sum);
        // plan2
        Integer integer1 = list.stream().reduce(Integer::sum).orElse(-1);
        System.out.println(integer);
        System.out.println(integer1);

    }

    @Test
    // 2. 计算整数列表中所有偶数的平均值、最大值、最小值和总和
    public void calculateEvenNumbersAverage() {
        List<Integer> list = Arrays.asList(6, 5, 4, 3, 2, 1);
        // mapToInt 方法将流中的每个元素应用 mapper 函数，将其转换为 int 类型。
        //转换后的 int 值将组成一个新的 IntStream。
        list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::valueOf).average().ifPresent(System.out::println);
        list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::valueOf).min().ifPresent(System.out::println);
        list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::valueOf).max().ifPresent(System.out::println);
        System.out.println(list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::valueOf).sum());
    }

    @Test
    // 3. 筛选出一个整数列表中的偶数并打印
    public void filterAndPrintEvenNumbers() {
        List<Integer> list = Arrays.asList(6, 5, 4, 3, 2, 1);
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    @Test
    // 4. 将字符串列表中的每个元素转换为大写并收集到新的列表
    public void convertToUppercaseAndCollect() {
        List<String> list = Arrays.asList("abc", "bbc", "cwa","dad", "ewe");
        List<String> stringList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

    @Test
    // 5. 对整数列表进行降序/升序排序，并获取前3个元素
    public void sortDescendingAndGetTopThree() {
        List<Integer> list = Arrays.asList(3, 5, 1, 2, 6, 4);
        List<Integer> descendList = list.stream().sorted((a, b) -> a - b).limit(3).collect(Collectors.toList());
        List<Integer> ascendList = list.stream().sorted((a, b) -> b - a).limit(3).collect(Collectors.toList());
        descendList.forEach(System.out::println);
        System.out.println("======");
        ascendList.forEach(System.out::println);
    }

    @Test
    // 6. 将整数列表中的每个数字乘以2
    public void doubleEachInteger() {
        List<Integer> list = Arrays.asList(3, 5, 1, 2, 6, 4);
        List<Integer> integerList = list.stream().map(n -> n * 2).collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }

    @Test
    // 6. 检查整数列表中是否所有数字都是正数
    public void allNumbersArePositive() {
        List<Integer> list = Arrays.asList(3, 5, -1, -2, 6, -4);
        // 1. 统计正数个数判断与list本身大小是否相同
        long count = list.stream().filter(n -> n >= 0).mapToInt(Integer::valueOf).count();
        System.out.println(list.size() == count);
        // 2. 判断有负数就输出否
        System.out.println(list.stream().allMatch(n -> n >= 0));
    }

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
