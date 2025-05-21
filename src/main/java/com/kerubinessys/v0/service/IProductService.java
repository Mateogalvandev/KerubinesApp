package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;

import java.util.List;

public interface IProductService {

    public void saveProduct(Product product);

    public Product findProduct(Long id);

    public List<Product> getProduct();

    public void deleteProduct(Long id);

    public void editProduct(Long id, String productName, String productDescription,
                            Double cost, String color, String size, Long stock,
                            String category, List<Sale> saleList);


}
