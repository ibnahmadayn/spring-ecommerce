package com.cakefactory.catalog.persistence;

import com.cakefactory.catalog.CatalogService;
import com.cakefactory.catalog.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaCatalogService implements CatalogService {

    private final CatalogRepository repository;

    public JpaCatalogService(CatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getItems() {
        return repository.findAll().stream().map(itemEntity -> new Item(itemEntity.title, itemEntity.price)).toList();
    }
}
