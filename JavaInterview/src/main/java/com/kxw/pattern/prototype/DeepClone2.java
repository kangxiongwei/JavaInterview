package com.kxw.pattern.prototype;

/**
 * Created by kangxiongwei on 2015/7/18.
 * 使用序列化，反序列化实现深拷贝
 * 不用考虑对象引用关系
 */
public class DeepClone2 {

    public static void main(String[] args) throws Exception{

        Teacher teacher = new Teacher();
        teacher.setType(1);
        teacher.setName("张三");

        Student student = new Student();
        student.setName("学生1");
        student.setAge(20);
        student.setTeacher(teacher);
        System.out.println("~~~~~~~~~~~~~~~深拷贝之前~~~~~~~~~~~~~~~~");
        System.out.println(student);
        Student student1 = (Student)student.deepCopy();
        System.out.println("~~~~~~~~~~~~~~~深拷贝之后~~~~~~~~~~~~~~~~");
        System.out.println(student1);
        System.out.println("~~~~~~~~~~~~~~修改拷贝的对象~~~~~~~~~~~~~~~~~");
        student1.getTeacher().setName("李四");
        System.out.println(student);

    }

}
