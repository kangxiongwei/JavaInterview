package com.kxw.spring.ioc;

/**
 * Created by kangxiongwei on 2017/6/14.
 */
public class World {

    private Person person;
    private Animal animal;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "World{" +
                "person=" + person +
                ", animal=" + animal +
                '}';
    }
}
