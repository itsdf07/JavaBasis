package com.aso.javabasis.datastruct;

/**
 * Created by itsdf07 on 2017/11/5 20:30.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class LinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size;

    public LinkedList() {

    }

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
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            linkLast(e);
        } else {
            Node<E> target = node(index);
            Node<E> pre = target.prev;
            Node<E> newNode = new Node<>(pre, e, target);
            //有坑
            if (pre == null) {
                first = newNode;
            } else {
                pre.next = newNode;
            }
//            pre = newNode;
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
        System.out.println(target.item);
        unLinkNode(target);
    }

    private void unLinkNode(Node<E> p) {
//        p.prev.next = p.next;
//        p.next.prev = p.prev;

        Node<E> pre = p.prev;
        Node<E> next = p.next;
        //等价于删除第一个节点
        if (pre == null) {
            first = p.next;
        } else {
            pre.next = p.next;
        }
        //删除与删除尾节点
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

    private Node<E> node(int index) {
        if (index < (size >> 1)) {//index 处于前半部分
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {//index 处于后半部分
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {//从后往前查找
                node = node.prev;
            }
            return node;
        }
    }

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
