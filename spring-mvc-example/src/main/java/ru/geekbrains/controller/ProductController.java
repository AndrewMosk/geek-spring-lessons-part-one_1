package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String  productList(Model model,
                               @RequestParam(name = "minPrice",required = false, defaultValue = "false") Boolean minPrice,
                               @RequestParam(name = "maxPrice",required = false, defaultValue = "false") Boolean maxPrice) {
        logger.info("product list");


        model.addAttribute("products", productService.filterByPrice(minPrice, maxPrice));
        return "products";
    }

    @GetMapping("new")
    public String createProduct(Model model) {
        logger.info("create list");
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping
    public String  saveProduct(Product product) {
        logger.info("save list");
        productService.save(product);
        return "redirect:/product";
    }

}
