/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.model;

public class Product {
    private long id;
    private String name, description;
    private double price;
    private String dateIns;
    private EnumProductType productType;

    public Product(long id, String name, String desc, double price, 
            String dateIns, EnumProductType productType){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.dateIns = dateIns;
        this.productType = productType;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateIns() {
        return dateIns;
    }

    public void setDateIns(String dateIns) {
        this.dateIns = dateIns;
    }

    public EnumProductType getProductType() {
        return productType;
    }

    public void setProductType(EnumProductType productType) {
        this.productType = productType;
    }
       
}