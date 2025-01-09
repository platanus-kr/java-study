package o.e._01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassObjects {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("o.e._01.ClassObjects$Square");

        var circleObject = new Drawable() {
            @Override
            public int gerNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(stringClass, hashMapClass, squareClass,
                Collection.class, boolean.class, int[][].class, Color.class,
                circleObject.getClass());
    }
    private static void printClassInfo(Class<?> ... classes) {
        for (Class<?> clazz : classes) {
            System.out.println(String.format("클래스 이름 : %s, 클래스 패키지 명 : %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));
            System.out.println(String.format("타입 : %s",
                    clazz.getTypeName()));

            Class<?>[] implementedInterfaces = clazz.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("%s 클래스 implement : %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("배열 : " + clazz.isArray());
            System.out.println("원시타입 : " + clazz.isPrimitive());
            System.out.println("열거타입 : " + clazz.isEnum());
            System.out.println("인터페이스 : " + clazz.isInterface());
            System.out.println("익명클래스 : " + clazz.isAnonymousClass());

            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable {
        @Override
        public int gerNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int gerNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }
}
