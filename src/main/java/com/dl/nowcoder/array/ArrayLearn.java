package com.dl.nowcoder.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayLearn {
    /**
     * 排序
     *
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
     * HJ11 数字颠倒:输入一个整数，将改正数逆序输出
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
     *
     * @param input
     */
    public void reverseStr(String input) {
        StringBuffer inputBuffer = new StringBuffer(input);
        System.out.println(inputBuffer.reverse());
    }


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
        ArrayLearn arrayLearn = new ArrayLearn();
//        arrayLearn.reverseStr(a);
        List<String> newLsit = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String> oldList = Arrays.asList("d", "c", "e", "u", "q", "r", "t");
        arrayLearn.getDiffsInList(newLsit, oldList);
    }

    /**
     * 寻找两个列表中的相同、不同的元素
     */
    public void getDiffsInList(List<String> newLsit, List<String> oldList) {
        Map<String, Integer> listMap = newLsit.stream().collect(Collectors.toMap(s -> s, s -> 0));
        for (String s : oldList) {
            //循环old列表，如果元素在map中存在说明new列表也存在该数据，是共有的，否则是old独有的
            Integer value = listMap.getOrDefault(s, 3);
            //默认值0，old独有的值是3，
            if (value == 3) {
                listMap.put(s, 3);
            }else{
                listMap.put(s, 2);
            }
        }
        List<String> commonList = new ArrayList<String>();
        List<String> newUniqueList = new ArrayList<String>();
        List<String> oldUniqueList = new ArrayList<String>();
        Set<String> strings = listMap.keySet();
        for (String key : strings) {
            if (listMap.get(key) == 0) {
                newUniqueList.add(key);
            } else if (listMap.get(key) == 2) {
                commonList.add(key);
            } else if (listMap.get(key) == 3) {
                oldUniqueList.add(key);
            }
        }
        System.out.println("共有:" + commonList.stream().collect(Collectors.joining(";")));
        System.out.println("newLsit独有:" + newUniqueList.stream().collect(Collectors.joining(";")));
        System.out.println("oldList独有:" + oldUniqueList.stream().collect(Collectors.joining(";")));
    }
}
