package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        averageGrade += delta;
    }

    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    /*
    7.4.	Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,
чтобы они вместо набора параметров принимали по одному объекту даты.
     */

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (Double.compare(student.averageGrade, averageGrade) != 0) return false;
        if (course != student.course) return false;
        if (beginningOfSession != null ? !beginningOfSession.equals(student.beginningOfSession) : student.beginningOfSession != null)
            return false;
        return endOfSession != null ? endOfSession.equals(student.endOfSession) : student.endOfSession == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(averageGrade);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (beginningOfSession != null ? beginningOfSession.hashCode() : 0);
        result = 31 * result + (endOfSession != null ? endOfSession.hashCode() : 0);
        result = 31 * result + course;
        return result;
    }
}
