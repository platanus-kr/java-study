package org.codepractice.JavaClassAndObjectBasic.StaticTest;

public class Student {

    private int id;
    private String name;

    public Student(int generatedId, String studentName) {
        id = generatedId;
        name = studentName;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return id == student.id;
        }
        return false;
    }
}
