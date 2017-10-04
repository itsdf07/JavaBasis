package com.aso.javabasis;

/**
 * 九九乘法表的打印
 * Created by itsdf07 on 2017/4/1 11:41.
 * E-Mail: 923255742@qq.com
 * GitHub: https://github.com/itsdf07
 */

public class Print9x9 {
    public static void main(String[] arg) {
        System.out.println("执行了Print9x9.java的主程序...");
        print9x9_1();
    }

    /**
     * 一个for循环实现 9 9 乘法表
     */
    private static void print9x9_1() {
        String result = "九九乘法表:\n";
        for (int i = 1, j = 1; i <= 9; j++) {
            result += j + " * " + i + " = " + i * j + "\t";
            if (i == j) {
                j = 0;
                i++;
                result += "\n";
            }
        }
        System.out.println(result);
    }

    /**
     * 两个for循环（递归方式）实现 9 9 乘法表
     */
    private static void print9x9_2() {
        String result = "九九乘法表:\n";
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                result += j + " * " + i + " = " + i * j + "\t";
            }
            result += "\n";
        }
        System.out.println(result);
    }

    /**
     * 二维数组实现 9 9 乘法表
     */
    private static void print9x9_3() {
        int i, j;
        int[][] a = new int[10][10];
        for (i = 1; i <= 9; i++) {
            for (j = 1; j <= i; j++) {
                a[i][j] = i * j;
                System.out.print(j + " * " + i + " = " + a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void print9x9_4() {
        outer:
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
        }
    }

    //用 DoWhile --99

    /**
     *
     */
    private static void print9x9_5() {
        int i = 1, j;
        do {
            j = 1;
            do {
                if (j <= i) {
                    System.out.print(j + " * " + i + " = " + (i * j) + "\t");
                } else {
                    break;
                }
                j++;
            } while (j <= 9);
            System.out.println();
            i++;
        } while (i <= 9);
    }
}
