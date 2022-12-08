package com.cakefactory.catalog;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class InMemoryCatalogService implements CatalogService {
    @Override
    public List<Item> getItems() {
        return List.of(
                new Item("Item 1", BigDecimal.valueOf(9.9)),
                new Item("Item 2", BigDecimal.valueOf(19.9)),
                new Item("Item 3", BigDecimal.valueOf(29.9))
        );
    }
}
