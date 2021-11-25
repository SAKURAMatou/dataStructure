package com.dl.nowcoder;

/**
 * @author DML
 * @descriptions
 * @date 2021-11-25 8:54
 */
public class StringTest {

    /**
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

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        String str1="asdfas";
        String str2="werasdfaswer";
        System.out.println(stringTest.getCommonStr(str1,str2));
    }
}
