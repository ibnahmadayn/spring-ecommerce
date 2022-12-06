package com.cakefactory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryCatalog implements Catalog {
    @Override
    public List<Item> getItems() {
        return Arrays.asList(
                new Item("Item 1", BigDecimal.valueOf(9.9)),
                new Item("Item 2", BigDecimal.valueOf(19.9)),
                new Item("Item 3", BigDecimal.valueOf(29.9))
        );
    }
}
