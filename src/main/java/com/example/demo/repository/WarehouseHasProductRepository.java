package com.example.demo.repository;

import com.example.demo.model.WarehouseHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseHasProductRepository extends JpaRepository <WarehouseHasProduct, Integer>{
}
