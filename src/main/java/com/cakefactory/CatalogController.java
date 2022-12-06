package com.cakefactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    InMemoryCatalog catalog;

    @GetMapping
    String index(Model model) {
        model.addAttribute("catalog", catalog.getItems());
        return "catalog";
    }
}
