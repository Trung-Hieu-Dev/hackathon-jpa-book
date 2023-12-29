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
    
    @ManyToOne @JoinColumn(name = "member_id") // primary use JoinColumn
    private Member member;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    
    @OneToOne @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    
    private LocalDateTime orderDate;
    
    // status: enum(ORDER, CANCEL)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
}