package com.kxw.serialize;


import java.io.*;

public class Person implements Externalizable {

    static class Handler {
        private static final Person person = new Person("kangxiongwei", 27, Gender.MALE);
    }

    //单例
    public static Person getInstance() {
        return Handler.person;
    }

    private String name = null;

    private transient Integer age = null;

    private Gender gender = null;

    public Person() {
        System.out.println("none-arg constructor");
    }

    public Person(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        gender = (Gender) in.readObject();
    }

    private Object readResolve() throws ObjectStreamException {
        return Handler.person;
    }
}