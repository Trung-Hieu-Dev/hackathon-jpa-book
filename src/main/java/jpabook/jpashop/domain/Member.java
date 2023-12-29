package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    
    @Embedded // this field belong to this class
    private Address address;
    
    @OneToMany(mappedBy = "member") // secondary use mappedBy
    private List<Order> orders = new ArrayList<>();
    
}
