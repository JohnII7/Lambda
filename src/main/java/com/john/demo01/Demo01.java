package com.john.demo01;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @author John117
 * @date 2022/08/06  18:54
 * @description
 */
public class Demo01 {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("新线程run方法被执行了")).start();
        System.out.println(calculateNum(Integer::sum));

        printNum(value -> value % 2 == 0);
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.print(i+" ");
            }
        }
    }
}
