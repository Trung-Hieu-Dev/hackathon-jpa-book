package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;
    
    
    /**
     *  Save item
     * */
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }
    
    /**
     *  Retrieve all
     * */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
    
    /**
     *  Retrieve one
     * */
    public Item findItem(Long itemId) {
        return itemRepository.findOne(itemId);
    }
    
}
