package com.aso.javabasis.datastruct;

/**
 * Created by itsdf07 on 2017/11/5 20:58.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class TestDataStructMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(7);

        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(i + " : " + linkedList.get(i));
        }
        System.out.println();
        linkedList.add(0,6);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(i + " : " + linkedList.get(i));
        }
        System.out.println();
        linkedList.remove(2);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(i + " : " + linkedList.get(i));
        }
    }
}
