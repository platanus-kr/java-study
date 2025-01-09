package org.codepractice.JavaClassAndObjectBasic;


class BirthDay {

    int day;
    int month;
    int year;

    public void setYear(int year) {
        // 생성된 자신을 바라본다.
        // 예컨데 인스턴스를 생성 후 메소드를 실행하면 인스턴스 자신을 바라본다.
        this.year = year;
    }

    public void printThis() {
        System.out.println(this);
    }
}

class Example {

    public static void main(String[] args) {
        BirthDay bDay = new BirthDay();
        bDay.setYear(2000);
        // 같은 결과물.
        System.out.println(bDay);
        bDay.printThis();
    }
}

