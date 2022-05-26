package com.example.marketplace_food.dao;

import com.example.marketplace_food.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDAO {
    private static int PRODUCT_COUNT;
    private Map<Integer, Product> productsList;

    {
        productsList = new HashMap<>();
        productsList.put(++PRODUCT_COUNT, new Product("Beef", 5.55, "Fresh beef"));
        productsList.put(++PRODUCT_COUNT, new Product("Milk", 1.55, "Fresh milk"));
    }

    public List<Product> index() {
        System.out.println(productsList);
        return new ArrayList<>(productsList.values());
    }

    public Product show(int id) {
        return productsList.get(id);
    }

}
