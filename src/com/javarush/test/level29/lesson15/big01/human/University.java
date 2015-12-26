package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student result = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                result = student;
            }
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = 0.0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
            }
        }

        return getStudentWithAverageGrade(maxAverageGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minAverageGrade = Integer.MAX_VALUE;

        for (Student student : students) {
            if (student.getAverageGrade() < minAverageGrade) {
                minAverageGrade = student.getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(minAverageGrade);
    }

    public void expel(Student student) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(student)) {
                iterator.remove();
            }
        }
    }
}
/*

 */