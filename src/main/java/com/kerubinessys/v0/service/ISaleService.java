package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    public void saveSale(Sale sale);

    public Sale findSale(Long id);

    public List<Sale> getSale();

    public void deleteSale(Long id);

    public void editSale(Long id, LocalDate date, String typeSale, List<Product> productList,
                         UserApp userApp, Double totalCost);
}
