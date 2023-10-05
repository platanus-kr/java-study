package c.e.couchbase01.domain;


public enum OrderStatus {
    PAYED("01", "PAYED"),
    CANCELED("99", "ORDER CANCELD");

    private final String code;
    private final String name;


    OrderStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
