package o.e._02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorClass {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        printConstructorData(Person.class);
        printConstructorData(Address.class);

        Person person = (Person) createInstanceWithArguments(Person.class);
        System.out.println(person);

        Person secondPerson = (Person) createInstanceWithArguments(Person.class, "아이유", 32);
        System.out.println(secondPerson);

        Address address = (Address) createInstanceWithArguments(Address.class, "서울시", 123);
        Person thridPerson = (Person) createInstanceWithArguments(Person.class, address,"이지금", 32);
        System.out.println(thridPerson);

        Address fourthAddress = createInstanceWithGenericAndArguments(Address.class, "서울시", 123);
        Person fourthPerson = createInstanceWithGenericAndArguments(Person.class, address,"이지금", 32);
        System.out.println(fourthPerson);
    }

    public static Object createInstanceWithArguments(Class<?> clazz, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == args.length) {
                return constructor.newInstance(args);
            }
        }
        System.out.println("생성자를 찾지 못했습니다.");
        return null;
    }

    public static <T> T createInstanceWithGenericAndArguments(Class<?> clazz, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == args.length) {
                return (T) constructor.newInstance(args);
            }
        }
        System.out.println("생성자를 찾지 못했습니다.");
        return null;
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format(
                "%s 클래스는 %d 개의 선언된 생성자가 있다.",
                clazz.getSimpleName(),
                constructors.length)
        );

        for (Constructor<?> constructor : constructors) {
            // 생성자가 받는 파라미터의 타입을 가져온다
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(t -> t.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);

        }
    }

    public static class Person {
        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "익명";
            this.age = 0;
            this.address = null;
        }

        // 여러개의 생성자가 오버로드 됨..
        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.name = name;
            this.age = 0;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

}
