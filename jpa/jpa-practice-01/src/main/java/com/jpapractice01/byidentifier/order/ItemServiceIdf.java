package com.jpapractice01.byidentifier.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceIdf {
    private final OrderRepositoryIdf orderRepositoryIdf;

    @Transactional
    public void appendItem(long orderId, ItemIdf itemIdf) {
        OrdersIdf findOrder = orderRepositoryIdf.findById(orderId).orElseThrow(IllegalArgumentException::new);
        findOrder.addItem(itemIdf);
    }

    @Transactional
    public List<ItemIdf> retrieveOrderItems(long orderId) {
        /**
         * 준영속 상태의 컨텍스트에서 실제 컨텍스트를 추출하기 위해서는 다음과 같은 방법이 있다.
         * 1. Fetch join 쿼리 : JPQL을 사용해 fetch join으로 한번에 가져온다.
         * 2. Fetch 전략 변경 : 엔티티의 fetch 전략을 Lazy에서 Entity로 변경한다
         * 3. EntityGraph : 특정 JPA 메소드 호출시에만 로딩 전략을 변경한다.
         * 4. Transactional annotation (현재) : 특정 서비스 로직 내에서 준영속 컨텍스트에 접근해 entity를 불러온다.
         */
        OrdersIdf ordersIdf = orderRepositoryIdf.findById(orderId).orElseThrow(IllegalArgumentException::new);
        List<ItemIdf> itemIdfs = ordersIdf.getItems();
        itemIdfs.size(); // DTO 변환 등등의 작업을 위해 컬렉션에 접근하여 엔티티 명시 (컬렉션 접근)
        return itemIdfs;
    }
}
