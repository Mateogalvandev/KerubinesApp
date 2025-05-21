package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public List<Product> getProduct() {
       List<Product> productList = productRepository.findAll();
       return productList;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public void editProduct(Long id, String productName, String productDescription, Double cost,
                            String color, String size, Long stock, String category, List<Sale> saleList) {
        Product product = this.findProduct(id);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setCost(cost);
        product.setColor(color);
        product.setSize(size);
        product.setStock(stock);
        product.setCategory(category);
        product.setSaleList(saleList);

        this.saveProduct(product);

    }

}
