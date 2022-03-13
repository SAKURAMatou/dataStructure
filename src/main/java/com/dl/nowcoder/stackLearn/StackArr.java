package com.dl.nowcoder.stackLearn;

public class StackArr {
    //链表存储数据对象
    private String[] items;
    //栈顶的下标
    private int count;
    //栈的大小
    private int n;

    public void StackArr(int n) {
        //初始化长度为n的数组用于存放栈的数据；
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈
     *
     * @param item
     */
    public boolean push(String item) {
        //当栈的数据量大于长度时禁止入栈
        if (count == n) {
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈;顺序栈出栈理解为，把栈顶元素下边-1
     *
     * @return
     */
    public String pop() {
        if (count == 0) return null;
        String old = items[count - 1];
        items[count] = null;
        --count;
        return old;
    }

}
