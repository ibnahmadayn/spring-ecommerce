package com.cakefactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Catalog {
    public List<Item> getItems();
}
