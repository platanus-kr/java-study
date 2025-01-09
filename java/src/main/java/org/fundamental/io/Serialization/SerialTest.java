package org.fundamental.io.Serialization;

import java.io.*;

class Person implements Serializable {

    //    private static final long serialVersionUID = -2345L;
    String name;
    String job;

    public Person() {
    }

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString() {
        return name + ", " + job;
    }
}

public class SerialTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Person personKang = new Person("Kang", "CEO");
        Person personPak = new Person("Pak", "CTO");

        try (FileOutputStream fos = new FileOutputStream("serial.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(personKang);
            oos.writeObject(personPak);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ///
        try (FileInputStream fis = new FileInputStream("serial.out");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person s1 = (Person) ois.readObject();
            Person s2 = (Person) ois.readObject();
            System.out.println(s1);
            System.out.println(s2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
