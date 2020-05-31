package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
                               @RequestParam(name = "maxPrice",required = false, defaultValue = "false") Boolean maxPrice,
                               @RequestParam (name = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam (name = "size", required = false, defaultValue = "5") Integer size) {
        logger.info("product list");


        model.addAttribute("productsPage", productService.filterByPrice(minPrice, maxPrice, PageRequest.of(page-1, size)));
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
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
