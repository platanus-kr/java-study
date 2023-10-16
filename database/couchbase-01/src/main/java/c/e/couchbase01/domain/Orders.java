package c.e.couchbase01.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private List<Item> items;

    @Field
    private OrderStatus status;

    @Field
    @CreatedDate
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime atOrdered;

    public Orders(String id, List<Item> items, OrderStatus status, LocalDateTime atOrdered) {
        this.id = id;
        this.items = items;
        this.status = status;
        this.atOrdered = atOrdered;
    }

    public Orders() {
    }

    public Orders(List<Item> items, OrderStatus status) {
        this.items = items;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getAtOrdered() {
        return atOrdered;
    }
}
