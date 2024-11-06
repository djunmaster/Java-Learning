package com.pilot.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

@Getter
@AllArgsConstructor
class Employee {
    private String name;
    private int age;
}
public class StreamAdvancedQuestionPractice {
    private List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Employee("Alice", 22),
                new Employee("Bob", 20),
                new Employee("Charlie", 21),
                new Employee("David", 20)
        );
    }

    @Test
    // 从员工（姓名、年龄）列表中找出年龄大于30岁的员工姓名列表
    public void getNamesOfEmployeesOverThirty() {
        List<Employee> employeeList = getEmployeeList();
        List<String> list = employeeList.stream().filter(employee -> employee.getAge() > 30).map(Employee::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    // 计算列表中每个元素出现的次数
    public void countElementOccurrences() {
        List<Integer> integerNumbers = Arrays.asList(1, 2, 4, 3, 6, 3, 8, 5);
        Map<Integer, Long> collect = integerNumbers.stream().collect(Collectors.groupingBy(e -> e, counting()));
        System.out.println(collect);
    }

    @Test
    // 对字符串列表按单词长度进行分组，并打印出每个长度组的单词列表
    public void printWordGroupsByLength() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
    }

    @Test
    // 将整数列表中的数字分为奇数和偶数，分别存储在不同的列表中
    public void separateOddEvenNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 4, 3, 6, 3, 8, 5);
        // plan1
        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0));
        // plan2
        Map<Boolean, List<Integer>> collect2 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect);
        System.out.println(collect2);
    }

    @Test
    // 将一个字符串列表中的每个字符串长度求和
    public void sumStringLengths() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        // plan1
        strings.stream().map(String::length).reduce(Integer::sum).ifPresent(System.out::println);
        // plan2
        System.out.println(strings.stream().mapToInt(String::length).sum());
        // plan3
        System.out.println(strings.stream().reduce("",String::concat).length());
    }

    @Test
    // 对员工列表按年龄分组，并打印每个年龄组的人数
    public void groupEmployeesByAgeAndPrintCount() {
        List<Employee> employeeList = getEmployeeList();
        Map<Integer, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, counting()));
        System.out.println(collect);
    }

    @Test
    // 计算字符串中每个字符出现的次数
    public void countCharacterOccurrences() {
        String str = "hello world";
        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, counting()));
        System.out.println(collect);
    }

    @Test
    // 给定两个字符串列表，合并这两个列表，并去除重复项，然后按字母顺序排序
    public void mergeAndSortUniqueStrings() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("b", "c", "d");
        // 升序排序
        List<String> list_asc = Stream.concat(list1.stream(), list2.stream()).distinct().sorted().collect(Collectors.toList());
        // 降序排序
        List<String> list_des = Stream.concat(list1.stream(), list2.stream()).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list_asc);
        System.out.println(list_des);
    }

    @Test
    // 将字符串列表转换为Map，其中键是字符串，值是字符串长度
    public void mapStringsToLength() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> collect = strings.stream().collect(Collectors.toMap(s -> s, String::length));
        System.out.println(collect);
    }
}
