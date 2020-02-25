package com.thoughtworks;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class App {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("3", "张三"),
            new Student("4", "李四"),
            new Student("5", "王五"),
            new Student("6", "赵六"),
            new Student("7", "钱七"));

        MemoryRepository<Student> mr = new MemoryRepository<>();

        for (Student student : students) {
            mr.save(student.getId(), student);
        }

        System.out.println(mr.get("3"));
        System.out.println("==================");

        mr.delete("4");
        Student fengWu = new Student("5", "冯五");
        mr.update("5", fengWu);
        RepositoryUtil.printList(mr.list());
    }
}
