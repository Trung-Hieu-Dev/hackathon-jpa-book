package jpabook.jpashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ItemServiceTest {
    
    @Autowired private ItemService itemService;
    
    @Test void saveItem() {
    
    }
    
    @Test void findItems() {
    }
    
    @Test void findItem() {
    }
}