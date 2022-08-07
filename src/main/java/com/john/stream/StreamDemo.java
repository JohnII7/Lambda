package com.john.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author John117
 * @date 2022/08/07  9:25
 * @description
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "狂风也追不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(4L, "易", 14, "是这个世界在限制他的思维", null);

        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();
        List<Book> book4 = new ArrayList<>();

        book1.add(new Book(1L, "道德两侧是光明与黑暗", "哲学，爱情", 88, "用一把刀划分了爱恨"));
        book1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长、爱情", 99, "讲述如何从失败到成功"));

        book1.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book1.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book1.add(new Book(4L, "吹或不吹", "爱情、个人传记", 56, "一个哲学家的爱情观注定很难"));

        book1.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么温柔"));
        book1.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家的灵魂和肉体的碰撞会激起怎样的火花"));
        book1.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家的灵魂和肉体的碰撞会激起怎样的火花"));

        author1.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book4);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
        return authorList;
    }
}
