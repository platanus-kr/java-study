package org.codepractice.JavaClassAndObjectBasic.StaticTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    public Student findByIdInstance1(int id) {
        return students.stream()
            .filter(student -> student.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
