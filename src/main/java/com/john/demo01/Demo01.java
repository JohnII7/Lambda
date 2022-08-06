package com.john.demo01;

import java.util.function.IntBinaryOperator;

/**
 * @author John117
 * @date 2022/08/06  18:54
 * @description
 */
public class Demo01 {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("新线程run方法被执行了")).start();
        System.out.println(calculateNum(Integer::sum));;
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
