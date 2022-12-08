package com.cakefactory.persistence;

import com.cakefactory.catalog.Item;
import com.cakefactory.catalog.persistence.CatalogRepository;
import com.cakefactory.catalog.persistence.ItemEntity;
import com.cakefactory.catalog.persistence.JpaCatalogService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class JpaCatalogServiceTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CatalogRepository repository;

    JpaCatalogService catalogService;

    @BeforeEach
    void setUp() { catalogService = new JpaCatalogService(repository); }

    @Test
    @DisplayName("returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge";
        addItemToDatabase(expectedTitle, BigDecimal.valueOf(0.5));
        List<Item> items = catalogService.getItems();
        Assertions.assertThat(items).anyMatch(item -> expectedTitle.equals(item.title()));
    }

    private void addItemToDatabase(String title, BigDecimal price) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.sku = "test-item-1";
        itemEntity.title = title;
        itemEntity.price = price;

        testEntityManager.persistAndFlush(itemEntity);
    }
}
