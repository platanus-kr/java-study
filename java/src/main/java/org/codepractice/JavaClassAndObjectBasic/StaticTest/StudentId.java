package org.codepractice.JavaClassAndObjectBasic.StaticTest;

public class StudentId {

    private int id;

    public int getIndex() {
        return id;
    }

    public int idGenerator() {
        int thisId = getIndex();
        return thisId + 1;
    }

}
