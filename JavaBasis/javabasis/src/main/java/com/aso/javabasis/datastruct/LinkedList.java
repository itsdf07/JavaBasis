package com.aso.javabasis.datastruct;

/**
 * 双向链表
 * Created by itsdf07 on 2017/11/5 20:30.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class LinkedList<E> {
    /**
     * 链表中第一个元素
     */
    Node<E> first;
    /**
     * 链表中最后一个元素
     */
    Node<E> last;
    /**
     * l链表中元素数
     */
    int size;

    public LinkedList() {

    }

    /**
     * add
     *
     * @param e
     */
    public void add(E e) {
        linkLast(e);
    }

    /**
     * 在index位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //如果添加的位置第一个位置（索引值为0）和最后一个位置（索引值为链表中元素数）之间，则为无法添加
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {//在链表尾部添加数据
            linkLast(e);
        } else {
            Node<E> target = node(index);
            Node<E> pre = target.prev;
            Node<E> newNode = new Node<>(pre, e, target);
            if (pre == null) {
                //target为第一个元素，前面则不再有元素，那么即为在链表头插入数据
                first = newNode;
            } else {
                //把target前一个元素的下一个连接元素指向新插入的元素
                pre.next = newNode;
            }
            //prev = newNode 写法是错的，相当于对象相等
            target.prev = newNode;
            size++;
        }
    }

    /**
     * 删除index的元素
     *
     * @param index
     */
    public void remove(int index) {
        Node<E> target = node(index);
        unLinkNode(target);
    }

    private void unLinkNode(Node<E> p) {

        Node<E> pre = p.prev;
        Node<E> next = p.next;
        //等价于删除第一个节点
        if (pre == null) {
            first = p.next;
        } else {
            pre.next = p.next;
        }
        //等价与删除尾节点
        if (next == null) {
            last = p.prev;
        } else {
            next.prev = p.prev;
        }
        size--;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return node(index).item;

    }

    /**
     * 取出index的元素
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        //if ... else 为优化遍历效率，index为前半部分时，从头遍历效率高，index为后半部分时，从后往前遍历效率高
        if (index < (size >> 1)) {//index 处于前半部分
            //初始一个node元素，遍历开始前，node为第一个元素
            Node<E> node = first;

            for (int i = 0; i < index; i++) {
                //开始遍历，node不断的指向下一个元素，直到所要指向的元素index索引
                node = node.next;
            }
            return node;
        } else {//index 处于后半部分
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {//从后往前查找
                //开始遍历，node不断的指向前一个元素，直到所要指向的元素index索引
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 在链表尾部添加元素
     *
     * @param e
     */
    private void linkLast(E e) {
        //添加到列表尾部，
        Node<E> newNode = new Node<E>(last, e, null);
        Node<E> l = last;
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        /**
         * 节点元素
         *
         * @param prev    前一个节点元素（第一个元素时，前一个节点则为null）
         * @param element 当前操作的节点元素
         * @param next    下一个节点元素（最后一个元素时，后一个节点则为null）
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
