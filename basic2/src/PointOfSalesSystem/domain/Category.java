package PointOfSalesSystem.domain;

public enum Category {

    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 초기 코드
}
