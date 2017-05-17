package com.kxw.pattern.prototype;

import java.io.*;

/**
 * Created by kangxiongwei on 2015/7/18.
 */
public class Student implements Cloneable,Serializable{

    private int age;
    private String name;
    private Teacher teacher;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //克隆一份自己
        Student student = (Student)super.clone();
        //将自己包含的引用克隆一份并保存
        Teacher teacher = (Teacher)student.getTeacher().clone();
        student.setTeacher(teacher);
        return student;
    }

    /**
     * 使用序列化进行深复制
     * @return
     */
    public Object deepCopy() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
