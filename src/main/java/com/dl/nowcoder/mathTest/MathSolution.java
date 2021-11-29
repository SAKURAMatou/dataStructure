package com.dl.nowcoder.mathTest;

import java.util.*;
import java.util.stream.Collectors;

public class MathSolution {
    /**
     * HJ76尼科彻斯定理:验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和
     * 3^3=7+9+11
     * <p>
     * 4^3=13+15+17+19
     * <p>
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出
     *
     * @param a
     */
    public void qienisike(int a) {
        int[] arr = new int[a];
        int middle = a / 2;
        if (a % 2 == 1) {
            //a为奇数时
            //arr[i]=a*a +(0-middle+i)*2
            for (int i = 0; i < a; i++) {
                arr[i] = a * a + (0 - middle + i) * 2;
            }
        } else {
            //a为偶数时
            //arr[i]=a*a+1 +(0-middle+i)*2
            for (int i = 0; i < a; i++) {
                arr[i] = a * a + 1 + (0 - middle + i) * 2;
            }
        }
        System.out.println(Arrays.stream(arr).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining("+")));
    }

    /**
     * HJ86 求最大连续bit数
     * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     *
     * @param a
     * @return
     */
    public int getMaxByteCount(int a) {
        //使用Javaapi转化为二进制字符串
        String str = Integer.toBinaryString(a);
        //求出二进制字符串中连续的1的数量;
        //字符串中只包含了0和1，通过0分割字符串；找出分割到的最长子串的长度
        Optional<String> max = Arrays.stream(str.split("0")).max(Comparator.comparing(String::length));
        if (max.isPresent()) {
            return max.get().length();
        } else {
            return 0;
        }
    }

    /**
     * 等差数列求和 初始值2 公差3 N=3n-1
     *
     * @param n
     */
    public void dengcha(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 3 * i - 1;
        }
        System.out.println(sum);
    }

    /**
     * HJ5将十六进制数值字符串转化为十进制
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示
     * 输入0xA，输出10
     *
     * @param in
     */
    public void jinzhizhuanhuan(String in) {
        HashMap<String, Integer> relationMap = new HashMap<String, Integer>() {
            {
                put("A", 10);
                put("B", 11);
                put("C", 12);
                put("D", 13);
                put("E", 14);
                put("F", 15);
            }
        };
        char[] chars = in.substring(2).toCharArray();
        int len = chars.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            //直接使用字符去获取对应的映射时，java操作字符时本质是操作字符对应的ASCII码；需要把字符转化为字符串
            String s = String.valueOf(chars[i]);
            if (relationMap.containsKey(s)) {
                sum += Math.pow(16, len - 1 - i) * relationMap.get(s);
            } else {
                sum += Math.pow(16, len - 1 - i) * Integer.valueOf(s);
            }
        }
        //字符串转整数需要使用Integer.valueOf；
        // Integer.getInteger(String)是获取系统属性，入参为系统属性的名称，不存在入参的系统属性时空指针
        System.out.println(sum);

    }

    /**
     * 统计字符串中每个字符出现次数
     *
     * @param str
     */
    public void countChars(String str) {
        char[] chars = str.toCharArray();
        HashMap<String, Integer> storage = new HashMap<String, Integer>(str.length());
        for (char c : chars) {
            String s = Character.toString(c);
            storage.put(s, storage.getOrDefault(s, 0) + 1);
        }
        Set<String> keySet = storage.keySet();
        for (String key : keySet) {
            System.out.println(key + ":" + storage.get(key));
        }

    }

    public static void main(String[] args) {
        MathSolution mathSolution = new MathSolution();
//        mathSolution.qienisike(6);
//        String str = "10011000111";
//        Optional<String> max = Arrays.stream(str.split("0")).max(Comparator.comparing(String::length));
//        System.out.println(max.get().length());
//        mathSolution.dengcha(275);
//        String a = "I am a student";
//        System.out.println(new StringBuffer(a).reverse());
//        mathSolution.jinzhizhuanhuan("0xC460");
        mathSolution.countChars("asdaa");
    }
}
