package com.cakefactory;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

@WebMvcTest(controllers = CatalogController.class)
@Import(InMemoryCatalog.class)
public class CatalogControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("catalog page returns list of items")
    void listsCatalogItems() throws Exception {
        try (WebClient webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build()) {
            HtmlPage page = webClient.getPage("http://localhost:8080/catalog");
            Assertions.assertEquals(3, page.querySelectorAll(".item-title").size());
        }
    }
}
