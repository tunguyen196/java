package com.security.controllers;

import com.security.models.Product;
import com.security.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")

    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("product/index");
        mv.addObject("products", productService.getList());
        System.out.print(productService.getList());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("product/create");
        mv.addObject("product", new Product());

        return mv;
    }

    @PostMapping("/create")
    public String store(@ModelAttribute Product product) {
        productService.createProduct(product);

       return "redirect:/product";
    }
}
