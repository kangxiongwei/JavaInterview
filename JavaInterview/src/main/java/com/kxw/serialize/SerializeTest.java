package com.kxw.serialize;

import java.io.*;

/**
 * Created by kangxiongwei on 2015/7/5.
 */
public class SerializeTest {

    public static void main(String[] args) throws Exception{
        Person person = new Person(22,"kangxiongwei",33.5);
        FileOutputStream fos = new FileOutputStream("person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.close();
        fos.close();
    }

}

class Person implements Serializable{

    private int age;

    private transient String name;

    private double salary;

    public Person(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

}
