package com.kxw.designpattern.prototype;

/**
 * Created by kangxiongwei on 2015/7/18.
 * 浅克隆
 * 只会拷贝一份对象的引用
 */
public class ShallowClone {

    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher();
        teacher.setType(1);
        teacher.setName("张三");

        Student student = new Student();
        student.setName("学生1");
        student.setAge(20);
        student.setTeacher(teacher);
        //浅克隆完成，Teacher指向了堆中的同一对象，所以，修改student1中teacher，也会将student中的teacher给修改掉
        Student student1 = (Student)student.clone();
        System.out.println(student1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        student1.getTeacher().setName("李四");
        System.out.println(student);
    }

}

