package c.e.couchbase01.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<Orders, String> {
    List<Orders> findByStatus(OrderStatus orderStatus);
}
