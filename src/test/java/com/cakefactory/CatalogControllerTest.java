package com.cakefactory;

import com.cakefactory.catalog.CatalogController;
import com.cakefactory.catalog.InMemoryCatalogService;
import com.cakefactory.catalog.Item;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CatalogController.class)
public class CatalogControllerTest {

    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InMemoryCatalogService catalog;

    @BeforeEach
    void setUp() {
        webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("catalog page returns list of items")
    void listsCatalogItems() throws Exception {
        mockItems();
        HtmlPage page = webClient.getPage("http://localhost:8080/catalog");
        assertThat(page.querySelectorAll(".item-title").size()).isEqualTo(3);
    }

    private void mockItems() {
        when(catalog.getItems()).thenReturn(List.of(
                new Item("Item 1", BigDecimal.valueOf(9.9)),
                new Item("Item 2", BigDecimal.valueOf(19.9)),
                new Item("Item 3", BigDecimal.valueOf(29.9))
        ));
    }
}
