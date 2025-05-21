package com.kerubinessys.v0.controller;


import com.kerubinessys.v0.model.Product;
import com.kerubinessys.v0.model.Sale;
import com.kerubinessys.v0.model.UserApp;
import com.kerubinessys.v0.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @GetMapping("/get")
    public List<Sale> getAllSales(){
        return saleService.getSale();
    }

    @GetMapping("/get/{id}")
    public String saleId(@PathVariable Long id){
        Sale sale = saleService.findSale(id);
        if (sale == null){
            return "ID Doesn't exits.";
        }
        return "The Sale is: " + sale + ".";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable Long id){
        saleService.deleteSale(id);
        String s = "ID was successfully deleted.";
        return s;
    }

    @PostMapping("/create")
    public String createSale(@RequestBody Sale sale){
        saleService.saveSale(sale);
        return "Sale was successfully created." + sale.getTypeSale();
    }

    @PutMapping("/edit/{id}")
    public Sale editSale(@PathVariable Long id,
                           @RequestParam (required = false, name = "typeSale") String typeSale,
                           @RequestParam (required = false, name = "productList") List<Product> productList,
                           @RequestParam (required = false, name = "userApp")UserApp userApp,
                           @RequestParam (required = false, name = "Date")LocalDate Date,
                           @RequestParam (required = false, name = "totalCost")Double Cost){
        saleService.editSale(id,Date, typeSale, productList, userApp, Cost);
        Sale sale = saleService.findSale(id);
        return sale;
    }








}
