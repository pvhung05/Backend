package com.example.demo.service;

import com.example.demo.model.WarehouseHasProduct;
import com.example.demo.repository.WarehouseHasProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseHasProductService {

    @Autowired
    private WarehouseHasProductRepository warehouseHasProductRepository;

    public List<WarehouseHasProduct> getAllWarehouseHasProduct() {
        return warehouseHasProductRepository.findAll();
    }

}
