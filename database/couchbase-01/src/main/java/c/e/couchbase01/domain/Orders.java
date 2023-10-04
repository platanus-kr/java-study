package c.e.couchbase01.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Person {

    @Id
    private String id;

    @Field
    @N
    private String firstName;
}
