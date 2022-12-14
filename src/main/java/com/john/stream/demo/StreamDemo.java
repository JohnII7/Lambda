package com.john.stream.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author John117
 * @date 2022/08/07  9:25
 * @description
 */
public class StreamDemo {
    public static void main(String[] args) {
//        test1(authors);
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
        test25();
    }

    private static void test25() {
        // reduce求年龄最小值
        Optional<Integer> reduce = getAuthors().stream()
                .map(Author::getAge)
                .reduce((integer, integer2) -> integer > integer2 ? integer2 : integer);
        reduce.ifPresent(System.out::println);
    }

    private static void test24() {
        // reduce求年龄最大值
        Integer reduce = getAuthors().stream().map(Author::getAge).reduce(Integer.MIN_VALUE, (integer, integer2) -> integer < integer2 ? integer2 : integer);
        System.out.println(reduce);

    }

    private static void test23() {
        // 使用reduce求所有作者年龄和
        Integer reduce = getAuthors().stream().distinct().map(Author::getAge).reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    private static void test22() {
        // 输出最小年龄作家姓名
        // min代替sorted
        Optional<Author> first = getAuthors().stream().min(Comparator.comparingInt(Author::getAge));
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test21() {
        // 获取任意一个年龄大于18的作家, 如果存在就输出
        Optional<Author> optionalAuthor = getAuthors().stream().filter(author -> author.getAge() > 18).findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test20() {
        // noneMatch
        boolean b = getAuthors().stream().noneMatch(author -> author.getAge() >= 100);
        System.out.println(b);
    }

    private static void test19() {
        // allMatch
        boolean b = getAuthors().stream().allMatch(author -> author.getAge() >= 18);
        System.out.println(b);
    }

    private static void test18() {
        // 判断是否有年龄29以上的作家
        boolean b = getAuthors().stream().anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
    }

    private static void test17() {
        // 获取一个Map集合, map的key为author, value为List<Book>
        Map<String, List<Book>> collect = getAuthors().stream().distinct().collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(collect);
    }

    private static void test16() {
        // 获取一个书名的Set集合
        Set<Book> collect = getAuthors().stream().flatMap(author -> author.getBooks().stream()).collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void test15() {
        // 获取一个存放作者名字的List集合
        List<String> collect = getAuthors().stream().map(Author::getName).toList();
        System.out.println(collect);
    }

    private static void test14() {
        // 打印所所有书籍的最高分和最低分
        Optional<Integer> max = getAuthors().stream().flatMap(author -> author.getBooks().stream()).map(Book::getScore).max(Comparator.comparingInt(o -> o));
        System.out.println(max.get());

        Optional<Integer> min = getAuthors().stream().flatMap(author -> author.getBooks().stream()).map(Book::getScore).min(Comparator.comparingInt(o -> o));
        System.out.println(min.get());

    }

    private static void test13() {
        // 去重打印所有作家的所有书籍数目
        long count = getAuthors().stream().flatMap(author -> author.getBooks().stream()).distinct().count();
        System.out.println(count);
    }

    private static void test12() {
        // 输出所有作家名字
        getAuthors().stream().map(Author::getName).distinct().forEach(System.out::println);
    }

    private static void test11() {
        // 打印所有数据的分类, 去重, 以及不能出现哲学爱情的分类
        getAuthors().stream().flatMap(author -> author.getBooks().stream()).distinct().flatMap(book -> Arrays.stream(book.getCategory().split(","))).distinct().forEach(System.out::println);

    }

    private static void test10() {
        // 打印所有书籍的名字，去重
        getAuthors().stream().flatMap(author -> author.getBooks().stream()).distinct().forEach(book -> System.out.println(book.getName()));
    }

    private static void test9() {
        // 去重打印除年龄最大作家的其他作家
        getAuthors().stream().distinct().sorted().skip(1).forEach(author -> System.out.println(author.getName()));
    }

    private static void test8() {
        // 对流中的元素降序去重排序, 打印年龄最大的两个
        List<Author> authors = getAuthors();
        authors.stream().distinct().sorted().limit(2).forEach(author -> System.out.println(author.getName()));
    }

    private static void test7() {
        // 对年龄降序去重
        getAuthors().stream().distinct().sorted((o1, o2) -> o2.getAge() - o1.getAge()).forEach(author -> System.out.println(author.getAge()));
    }


    private static void test6() {
        getAuthors().stream().distinct().forEach(author -> System.out.println(author.getName()));
    }

    private static void test5() {
        // 打印所有作家的姓名
        getAuthors().stream().map(Author::getName).forEach(System.out::println);

    }

    private static void test4() {
        // filter
        getAuthors().stream().filter(author -> author.getName().length() > 1).forEach(author -> System.out.println(author.getName()));
    }

    private static void test3() {
        // 双列stream操作
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 19);
        map.put("黑子", 17);
        map.put("日向翔阳", 16);
        map.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 17).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + "-->" + stringIntegerEntry.getValue()));
    }

    private static void test2() {
        // 打印大于3的
        Integer[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).distinct().filter(integer -> integer > 3).forEach(System.out::println);
    }

    // 打印年龄小于18的
    private static void test1(List<Author> authors) {
        authors.stream().distinct().filter(author -> author.getAge() < 18).forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "狂风也追不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();
        List<Book> book4 = new ArrayList<>();

        book1.add(new Book(1L, "道德两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        book1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败到成功"));

        book1.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book1.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book1.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的爱情观注定很难"));

        book1.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么温柔"));
        book1.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家的灵魂和肉体的碰撞会激起怎样的火花"));
        book1.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家的灵魂和肉体的碰撞会激起怎样的火花"));

        author1.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book4);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
    }
}
