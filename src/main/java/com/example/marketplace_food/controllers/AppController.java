package com.example.marketplace_food.controllers;

import com.example.marketplace_food.dao.ProductDAO;
import com.example.marketplace_food.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "show";
    }

    @GetMapping("/producer")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "producer";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        productDAO.save(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productDAO.show(id));
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("product") Product product, @PathVariable("id") int id) {
        productDAO.update(id, product);
        return "redirect:/";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/order")
    public String add(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "show"; }

    @PostMapping("/{id}/order")
        public String add(@PathVariable("id") int id) {
            productDAO.add(id);
            return "redirect:/"; }


    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("products", productDAO.view());
        return "basket"; }

    @PostMapping("/{id}/basket")
    public String deleteproduct(@PathVariable("id") int id) {
        productDAO.deleteproduct(id);
        return "redirect:/basket";
    }
}

