package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "orders")
public class Order {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    
    /**
     * fetch = FetchType.LAZY tức là khi bạn find, select đối tượng Order từ database thì nó sẽ không
     * lấy các đối tượng Member liên quan. (chi lay khi can thiet)
     *
     * fetch = FetchType.EAGER tức là khi bạn find, select đối tượng Order từ database thì tất cả các
     * đối tượng Member liên quan sẽ được lấy ra.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // primary use JoinColumn
    private Member member;
    
    
    /**
     * Cascade: https://stackjava.com/hibernate/cascade-trong-jpa-hibernate-la-gi-cac-loai-cascadetype.html
     * */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    
    private LocalDateTime orderDate;
    
    // status: enum(ORDER, CANCEL)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    // Association Assist Method
    // Member Entity
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    
    // OrderItem Entity
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    
    // Delivery Entity
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    
}
