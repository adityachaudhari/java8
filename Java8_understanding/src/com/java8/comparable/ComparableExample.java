package com.java8.comparable;

import com.java8.businessdataobjects.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

    public static void main(String args[]) {
        Employee e1= new Employee("John",28);
        Employee e2= new Employee("Ronny",21);
        Employee e3= new Employee("Tom",38);
        Employee e4= new Employee("Shawn",35);
        Employee e5= new Employee("Ron",36);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        Collections.sort(employeeList);

        for (Employee emp : employeeList) {
            System.out.print(emp.getAge()+ " ");
        }
    }
}
