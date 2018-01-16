package com.kxw.spring.ioc;

/**
 * Created by kangxiongwei on 2017/6/14.
 */
public class World {

    private String name;
    private Person person;
    private Animal animal;

    public World() {
    }

    public World(Person person, Animal animal) {
        this.person = person;
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
                "name='" + name + '\'' +
                ", person=" + person +
                ", animal=" + animal +
                '}';
    }
}
