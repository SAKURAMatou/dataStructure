package com.dl.nowcoder.mathTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
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

    public static void main(String[] args) {
        MathSolution mathSolution = new MathSolution();
//        mathSolution.qienisike(6);
//        String str = "10011000111";
//        Optional<String> max = Arrays.stream(str.split("0")).max(Comparator.comparing(String::length));
//        System.out.println(max.get().length());
//        mathSolution.dengcha(275);
        String a="I am a student";
        System.out.println(new StringBuffer(a).reverse());
    }
}
