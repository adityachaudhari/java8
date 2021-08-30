package com.java8.comparator;

import com.java8.businessdataobjects.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBeforeAndWithJava8 {


    public static void main(String args[]) {

        Student s1 = new Student(10,"John D", 20);
        Student s2 = new Student(8,"Ron C", 19);
        Student s3 = new Student(11,"Tom P", 23);
        Student s4 = new Student(15,"Gimmy D", 25);
        Student s5 = new Student(9,"Ronny D", 21);
        Student s6 = new Student(13,"Rock R", 20);

        List<Student> studentList= new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);

        System.out.println("************ Sorting by name using traditional java without anonymous and java 8  ************ \n");
        System.out.println("Before sorting by name :");
        studentList.forEach(student -> System.out.print(student.getName()+ " "));

        System.out.println("\n \n After sorting by name :");
        Collections.sort(studentList, new StudentNameComparator());
        studentList.forEach(student -> System.out.print(student.getName()+ " "));



        System.out.println("\n************ Sorting age with anonymouys inner class  ************ \n");
        System.out.println("Before sorting by age :");
        studentList.forEach(student -> System.out.print(student.getAge()+ " "));


        System.out.println("\nAfter sorting by age :");
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getAge().compareTo(student2.getAge());
            }
        });
        studentList.forEach(student -> System.out.print(student.getAge()+ " "));


        System.out.println("\n************ Sorting roll number with java 8 comparator  ************ \n");
        System.out.println("Before sorting roll no with java 8 lambda \n");
        studentList.forEach(student -> System.out.print(student.getRollno()+ " "));

        // with java 8 lambda
        Comparator<Student> compareByRollNumber = (Student stu1, Student stu2) -> stu1.getRollno().compareTo(stu2.getRollno());
        Collections.sort(studentList, compareByRollNumber);

        // Collections.sort(studentList, (Student stu1, Student stu2) -> stu1.getRollno().compareTo(stu2.getRollno())); can be done with this as well.
        // with java 8 comparing method using method reference
        //studentList.sort(Comparator.comparing(Student::getRollno));

        System.out.println("\nAfter sorting roll no with java 8 lambda");
        studentList.forEach(student -> System.out.print(student.getRollno()+ " "));


    }
}
