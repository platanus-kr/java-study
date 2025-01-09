package c.a.hd;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class GridEntity {

    private long id;
    private String blob;
    private LocalDateTime lastAccess;


    @Override
    public String toString() {
        return "GridEntity{" +
                "id=" + id +
                ", blob='" + blob + '\'' +
                ", lastAccess=" + lastAccess +
                '}';
    }
}
