package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse_has_product")
public class WarehouseHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idwarehouse")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "idproduct")

    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
