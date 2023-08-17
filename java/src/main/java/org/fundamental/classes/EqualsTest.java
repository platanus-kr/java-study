package org.fundamental.classes;


class Student {

    int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student std = (Student) obj;
            if (this.studentId == std.studentId) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString() {
        return studentId + ", " + studentName;
    }
}

public class EqualsTest {

    public static void main(String[] args) {
        Student student1 = new Student(100, "KANG");
        Student student2 = new Student(100, "KANG");
        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(System.identityHashCode(student1));
        System.out.println(System.identityHashCode(student2));
    }
}
