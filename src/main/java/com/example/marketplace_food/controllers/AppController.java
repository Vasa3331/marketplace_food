package com.example.marketplace_food.controllers;

import com.example.marketplace_food.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {
    private final ProductDAO productDAO;


    @Autowired
    public AppController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping ()
    public String index(Model model) {
        model.addAttribute("products", productDAO.index());
        return "products";
    }
    @GetMapping("products/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "show";
    }


    @GetMapping("/producer")
    public String producer() {
        return "producer";
    }

    @GetMapping("/basket")
    public String basket() { return "basket"; }
}
