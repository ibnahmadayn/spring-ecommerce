package com.cakefactory.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    final InMemoryCatalogService catalog;

    public CatalogController(InMemoryCatalogService catalog) {
        this.catalog = catalog;
    }

    @GetMapping
    ModelAndView index() {
        return new ModelAndView("catalog", Map.of("catalog", catalog.getItems()));
    }
}
