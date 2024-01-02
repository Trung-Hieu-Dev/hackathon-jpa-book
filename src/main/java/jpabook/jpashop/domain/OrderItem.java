package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "order_item")
public class OrderItem {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    private int orderPrice;
    
    private int count;
    
    //== Business Logic Method ==//
    /**
     *  Cancel order item
     * */
    public void cancel() {
        item.increaseStock(count);
    }
    
    public int getTotalPrice() {
        return orderPrice * count;
    }
    
    //== Create Method ==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        item.decreaseStock(count);
        
        return orderItem;
    }
}
