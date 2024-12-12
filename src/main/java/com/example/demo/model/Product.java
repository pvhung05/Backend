package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private Date importDate;
    private int stockQuantity;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private double price;
    @Setter
    @Getter
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice; // Reference back to Invoice


    @OneToMany(mappedBy = "id")
    private Set<WarehouseHasProduct> warehouseProducts;


    public Product() {}

    public Product(String name, double price, int quantity, Date importDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
    }


    public Set<WarehouseHasProduct> getWarehouseProducts() {
        return warehouseProducts;
    }

    public void setWarehouseProducts(Set<WarehouseHasProduct> warehouseProducts) {
        this.warehouseProducts = warehouseProducts;
    }
}
