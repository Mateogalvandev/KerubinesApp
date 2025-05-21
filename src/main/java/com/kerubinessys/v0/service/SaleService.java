package com.kerubinessys.v0.service;

import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;
import com.kerubinessys.v0.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public Sale findSale(Long id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        return sale;
    }

    @Override
    public List<Sale> getSale() {
        List<Sale> saleList = saleRepository.findAll();
        return saleList;
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);

    }

    @Override
    public void editSale(Long id, LocalDate date, String typeSale, List<Product> productList, UserApp userApp, Double totalCost) {
        Sale sale = this.findSale(id);
        sale.setTypeSale(typeSale);
        sale.setProductList(productList);
        sale.setUserSale(userApp);
        sale.setDate(date);
        sale.setTotalCost(totalCost);

        this.saveSale(sale);
    }
}
