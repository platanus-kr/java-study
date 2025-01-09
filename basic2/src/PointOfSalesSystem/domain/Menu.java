package PointOfSalesSystem.domain;

public class Menu {

    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public boolean isChicken() {
        return category == Category.CHICKEN;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    // 여기까지 초기 코드인듯?

}
