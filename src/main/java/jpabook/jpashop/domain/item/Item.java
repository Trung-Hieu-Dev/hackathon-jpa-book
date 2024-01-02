package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughException;
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
    
    //== Business Logic Method ==//
    /**
     * Increase stock
     * */
    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
    }
    
    /**
     * Decrease stock
     * */
    public void decreaseStock(int quantity) {
        int resStock = this.stockQuantity - quantity;
        
        if (resStock < 0) {
            throw new NotEnoughException("We need more stock"); // custom exception
        }
        
    }
}
