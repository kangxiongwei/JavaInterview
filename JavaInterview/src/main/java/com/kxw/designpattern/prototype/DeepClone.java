package com.kxw.designpattern.prototype;

/**
 * Created by kangxiongwei on 2015/7/18.
 * 深克隆
 * 解决浅克隆的问题：
 * 将被引用的对象在克隆一份
 */
public class DeepClone {

    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher();
        teacher.setType(1);
        teacher.setName("张三");

        Student student = new Student();
        student.setName("学生1");
        student.setAge(20);
        student.setTeacher(teacher);

        Student student1 = (Student)student.clone();
        System.out.println(student1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        student1.getTeacher().setName("李四");
        System.out.println(student);
    }

}
