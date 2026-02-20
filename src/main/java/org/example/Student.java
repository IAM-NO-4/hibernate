package org.example;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persons")
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int sid;
    private String name;
    private int age;
    @Column(name = "class",nullable = true)
   private String Class;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    Student(){}
    public Student(String name, int age, String aClass) {
        this.name = name;
        this.age = age;
        Class = aClass;
       // this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getclass() {
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Class='" + Class + '\'' +
                '}';
    }
}
