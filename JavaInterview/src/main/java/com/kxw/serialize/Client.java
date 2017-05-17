package com.kxw.serialize;

import java.io.*;

/**
 * 测试序列化
 * Created by kangxiongwei3 on 2017/5/17 16:38.
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Person person = new Person("kangxiongwei", 27, Gender.MALE);
        Person person = Person.getInstance();

        //简单的序列化，实现Serializable接口，输出为[kangxiongwei, 27, MALE]
        File file = new File("person.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        fis.close();
        System.out.println(obj);

        //将age设为transient，则不会序列化改字段，输出为[kangxiongwei, null, MALE]

        //让Person实现Externalizable接口，不重写writeExternal和readExternal，输出为[null, null, null]

        //重写writeExternal和readExternal，输出为[kangxiongwei, 27, null]

        System.out.println(person == obj);

    }


}
