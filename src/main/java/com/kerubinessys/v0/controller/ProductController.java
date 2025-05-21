package com.kerubinessys.v0.controller;

import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return productService.getProduct();
    }

    @GetMapping("/find/{id}")
    public String getProductById(@PathVariable Long id) {
        Product product = productService.findProduct(id);
        if (product == null) {
            return "Product by ID: " + id + " not found.";
        }
        return "Product was successfully localized";
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product was successfully created";
    }

    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id,
                                @RequestParam(required = false, name = "productName")String productName,
                                @RequestParam(required = false, name = "productDescription")String productDescription,
                                @RequestParam(required = false, name = "cost")Double cost,
                                @RequestParam(required = false, name = "color")String color,
                                @RequestParam(required = false, name = "size")String size,
                                @RequestParam(required = false, name = "stock")Long stock,
                                @RequestParam(required = false, name = "category")String category,
                                @RequestParam(required = false, name = "saleList")List<Sale> saleList)

    {
        productService.editProduct(id,productName,productDescription,cost,color,size,stock,category,saleList);
        Product product = productService.findProduct(id);
        return product;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productService.findProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}