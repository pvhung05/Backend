package com.example.demo.controller;

import com.example.demo.model.WarehouseHasProduct;
import com.example.demo.service.WarehouseHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://backend-awim.onrender.com")
@RestController
@RequestMapping("/api/warehousehasproduct")
public class WarehouseHasProductController {

    @Autowired
    private WarehouseHasProductService warehouseHasProductService;

    @RequestMapping
    public List<WarehouseHasProduct> getAllWarehousesHasProduct() {
        //System.out.println("hoang");
        return warehouseHasProductService.getAllWarehouseHasProduct();
    }

}
