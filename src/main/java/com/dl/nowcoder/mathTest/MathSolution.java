package com.dl.nowcoder.mathTest;

import java.util.Arrays;
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

    public static void main(String[] args) {
        MathSolution mathSolution = new MathSolution();
        mathSolution.qienisike(6);
    }
}
