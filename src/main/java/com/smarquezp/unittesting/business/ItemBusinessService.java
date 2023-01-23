package com.smarquezp.unittesting.business;

import com.smarquezp.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retreiveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
