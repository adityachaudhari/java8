package com.java8.businessdataobjects;

public class Employee implements Comparable<Employee> {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Employee employee) {
        if (this.age == employee.age) {
            return 0;
        } else if (this.age > employee.age) {
            return 1;
        } else {
            return -1;
        }
    }
}
