package com.cakefactory.catalog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CatalogRepository extends JpaRepository<ItemEntity, String> {
}
