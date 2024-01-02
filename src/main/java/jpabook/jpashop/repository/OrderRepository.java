package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager entityManager;
    
    // save
    public void save(Order order) {
        entityManager.persist(order);
    }
    
    
    // findOne
    public Order findOne(Long id) {
        return entityManager.find(Order.class, id);
    }
    
    
    //
}
