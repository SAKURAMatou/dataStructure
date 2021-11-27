package com.dl.nowcoder.array;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class ArrayLearn {
    /**
     * 排序
     * @param arr
     * @return
     */
    public int[] MySort(int[] arr) {
        PrimitiveIterator.OfInt iterator = Arrays.stream(arr).sorted().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            arr[i] = iterator.next();
            i++;
        }
        return arr;
    }

    /**
     *HJ11 数字颠倒:输入一个整数，将改正数逆序输出
     */
    public void reverseStr(int input) {
        String str = String.valueOf(input);
        char[] cha = str.toCharArray();
        StringBuffer res = new StringBuffer();
        //StringBuffer可以直接翻转字符串
//        res.reverse();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(cha[i]);
        }
        System.out.println(res.toString());
    }

    /**
     * HJ12接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     * @param input
     */
    public void reverseStr(String input){
        StringBuffer inputBuffer = new StringBuffer(input);
        System.out.println(inputBuffer.reverse());
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayLearn arrayLearn = new ArrayLearn();
        arrayLearn.reverseStr(a);
    }
}
