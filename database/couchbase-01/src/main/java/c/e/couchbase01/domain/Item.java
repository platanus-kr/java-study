package c.e.couchbase01.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

public class Item {

    @Id
    private String id;
    @Field
    @NotBlank
    private String skuCode;
    @Field
    @Min(value = 1, message = "어쩌구 ")
    private int ea;

    public Item(String id, String skuCode, int ea) {
        this.id = id;
        this.skuCode = skuCode;
        this.ea = ea;
    }

    public Item() {
    }

    public Item(String skuCode, int ea) {
        this.skuCode = skuCode;
        this.ea = ea;
    }

    public String getId() {
        return id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public int getEa() {
        return ea;
    }
}
