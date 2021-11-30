package com.dl.nowcoder.stringTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author DML
 * @descriptions
 * @date 2021-11-25 8:54
 */
public class StringTest {

    /**
     * HJ75：求两个字符串的最长公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public int getCommonStr(String str1, String str2) {
        int len = 0;
        if (str1 == null || str2 == null) {
            len = 0;
        } else {
            //一个字符串包含另一个时返回被包含的即可
            if (str1.contains(str2)) {
                return str2.length();
            } else if (str2.contains(str1)) {
                return str1.length();
            }
            //循环最短的字符串截取遍历看是否被长传包含
            String str = str1.length() > str2.length() ? str2 : str1;
            String c = str1.length() > str2.length() ? str1 : str2;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (c.contains(str.substring(i, j))) {
                        int tempLen = j - i;
                        len = tempLen > len ? tempLen : len;
                    }
                }
            }
        }
        return len;
    }

    /**
     * HJ85 最长回文子串
     * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
     * 暴力破解法，判断每个子串是否是回文；时间复杂度较高
     *
     * @param str
     */
    public void huiwenStrLen(String str) {
        int tempLen = 0;
        //如果自身是回文字符串时，最长子串即本身
        if (checkIsHuiwen(str)) {
            tempLen = str.length();
        } else {
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (checkIsHuiwen(str.substring(i, j))) {
                        int a = j - i;
                        tempLen = a > tempLen ? a : tempLen;
                    }
                }
            }
        }
        System.out.println(tempLen);
    }

    /**
     * 判断字符串是否是回文字符串
     * 回文字符串：对称，正序逆序一样的字符串
     *
     * @param str
     * @return
     */
    public boolean checkIsHuiwen(String str) {
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * HJ13句子逆序
     *
     * @param str
     */
    public void resverStrByWord(String str) {
        String[] splits = str.split(" ");
        String[] temp = new String[splits.length];
        for (int i = splits.length - 1; i >= 0; i--) {
            int a = splits.length - 1 - i;
            temp[a] = splits[i];
        }
        String res = Arrays.stream(temp).collect(Collectors.joining(" ")).toString();
        System.out.println(res);

    }

    /**
     * HJ14字符串比较
     * java直接使用字符串比较的话记比较的是字符串的ASCII码
     * 手动写比较器的话？
     *
     * @param strs
     */
    public void StrCompare(String[] strs) {
        Arrays.stream(strs).sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        String str1 = "I am a boy";
        String str2 = "werasdfaswer";
//        System.out.println(stringTest.getCommonStr(str1, str2));
//        stringTest.huiwenStrLen(str1);
//        System.out.println(stringTest.checkIsHuiwen(str1));
//        stringTest.resverStrByWord(str1);
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = scanner.next();
        }


    }
}
