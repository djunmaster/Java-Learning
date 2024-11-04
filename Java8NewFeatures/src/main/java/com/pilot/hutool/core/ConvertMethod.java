package com.pilot.hutool.core;

import cn.hutool.core.convert.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ConvertMethod {

    public void printStr(String str) {
        for (char ch : str.toCharArray()) {
            System.out.print(ch + "---");
        }
        System.out.println();
    }

    @Test
    public void ConvertStrMethod() {
        // 将其他类型转换为String类型
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        long[] b = {1, 2, 3, 4, 5};
        String bStr = Convert.toStr(b);
        System.out.println(bStr);
        printStr(bStr);

        double c = 3.14;
        String cStr = Convert.toStr(c);
        System.out.println(cStr);
        printStr(cStr);

        float d = 2.5f;
        String dStr = Convert.toStr(d);
        System.out.println(dStr);
        printStr(dStr);

        boolean e = true;
        String eStr = Convert.toStr(e);
        System.out.println(eStr);
        printStr(eStr);

        char f = 'A';
        String fStr = Convert.toStr(f);
        System.out.println(fStr);
        printStr(fStr);
    }

    public void printIntArray(Integer[] intArray) {
        // 将其他数值的数组类型转换为Integer类型
        for (Integer i : intArray) {
            System.out.print(i + "---");
        }
        System.out.println();
    }

    @Test
    public void ConvertIntArrayMethod() {
        String[] b = { "1", "2", "3", "4" };
        Integer[] intArrayB = Convert.toIntArray(b);
        printIntArray(intArrayB);

        long[] c = {1,2,3,4,5};
        Integer[] intArrayC = Convert.toIntArray(c);
        printIntArray(intArrayC);

        float[] f = {1.1f, 2.2f, 3.3f, 4.4f};
        Integer[] intArrayF = Convert.toIntArray(f);
        printIntArray(intArrayF);

        double[] g = {1.5, 2.5, 3.5, 4.5};
        Integer[] intArrayG = Convert.toIntArray(g);
        printIntArray(intArrayG);

        char[] h = {'1', '2', '3', '4'};
        Integer[] intArrayH = Convert.toIntArray(h);
        printIntArray(intArrayH);

        boolean[] i = {true, false, true, false};
        Integer[] intArrayI = Convert.toIntArray(i);
        printIntArray(intArrayI);
    }


    @Test
    public void ConvertDateAndListMethod() {
        // 1. String类型的日期可以解析为Date日期对象
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        LocalDateTime localDateTime = Convert.toLocalDateTime(a);
        System.out.println(value);
        System.out.println(localDateTime);
        // 2. 数组元素类型不一致也可以存放在一起
        Object[] mixedArray = {"abc", 123, "def", 456};
        List<?> mixedList = Convert.toList(mixedArray);
        System.out.println(mixedList);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
        private String city;
    }

    @Test
    public void ConvertToMapMethod() {
        
    }
}
