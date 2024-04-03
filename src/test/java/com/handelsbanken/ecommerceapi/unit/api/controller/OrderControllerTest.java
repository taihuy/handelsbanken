package com.handelsbanken.ecommerceapi.unit.api.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handelsbanken.ecommerceapi.api.controller.OrderController;
import com.handelsbanken.ecommerceapi.api.service.OrderService;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testCreateOrder() throws Exception {
        List<String> watchIds = Arrays.asList("1", "2", "3");
        double expectedPrice = 100.0;

        given(orderService.calculatePrice(watchIds)).willReturn(expectedPrice);

        // mockMvc.perform(post("/order")
        // .contentType("application/json")
        // .content("[\"1\", \"2\", \"3\"]"))
        // .andExpect(status().isOk())
        // .andExpect(jsonPath("$.price", equalTo(expectedPrice)));

        MockHttpServletResponse response = mockMvc.perform(post("/order")
                .contentType("application/json")
                .content("[\"1\", \"2\", \"3\"]"))
                .andReturn().getResponse();
        

        // Parse the response content into a Map
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = mapper.readValue(response.getContentAsString(),
                new TypeReference<Map<String, Object>>() {
                });

        
        assert response.getStatus() == HttpStatus.OK.value();
        assert responseMap.get("price").equals(expectedPrice);

    }
}