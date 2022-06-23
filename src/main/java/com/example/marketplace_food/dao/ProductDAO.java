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
    private Map<Integer, Product> productsOrder;

    {
        productsOrder = new HashMap<>();
        productsList = new HashMap<>();
        productsList.put(++PRODUCT_COUNT, new Product(PRODUCT_COUNT,"Beef", 5.55, "Fresh beef"));
        productsList.put(++PRODUCT_COUNT, new Product(PRODUCT_COUNT, "Milk", 1.55, "Fresh milk"));
    }

    public List<Product> index() {
        return new ArrayList<>(productsList.values());
    }

    public Product show(int id) {
        return productsList.get(id);
    }

    public void save(Product product) {
        product.setId(++PRODUCT_COUNT);
        productsList.put(PRODUCT_COUNT, product);
    }

    public void update(int id, Product updatedProduct) {
        Product productToBeUpdated = show(id);
        productToBeUpdated.setId(updatedProduct.getId());
        productToBeUpdated.setName(updatedProduct.getName());
        productToBeUpdated.setPrice(updatedProduct.getPrice());
        productToBeUpdated.setDescription(updatedProduct.getDescription());
    }
    public void delete(int id) {
        productsList.remove(id);
    }
    public List<Product> view() {
        return  new ArrayList<>(productsOrder.values());
    }

    public void add(int id) {
        productsOrder.put(id, productsList.get(id));
    }

    public void deleteproduct(int id) {
        productsOrder.remove(id);
    }
}
