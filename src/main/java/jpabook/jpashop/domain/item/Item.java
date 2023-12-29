package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // sign that, this table divided into some classes, need to collect fields from it's child.
@DiscriminatorColumn(name = "dtype") // the splitting point
@Getter @Setter
public abstract class Item {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    
    private String name;
    
    private int price;
    
    @Column(name = "stock_quantity")
    private int stockQuantity;
    
    @ManyToMany(mappedBy = "items") // secondary
    private List<Category> categories = new ArrayList<>();
}
