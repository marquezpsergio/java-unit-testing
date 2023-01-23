package com.smarquezp.unittesting.business;

import com.smarquezp.unittesting.data.ItemRepository;
import com.smarquezp.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @Mock
    ItemRepository repository;
    @InjectMocks
    private ItemBusinessService business;

    @Test
    void retriveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "Item1", 10, 10), new Item(2, "Item2", 20, 20)));
        List<Item> items = business.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}