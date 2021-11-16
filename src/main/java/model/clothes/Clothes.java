/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clothes;

import java.io.Serializable;


/**
 *
 * @author Ha Ngoc Bun
 */
public class Clothes implements Serializable{
    private int id;
    private String name;
    private String brand;
    private String color;
    private String material;
    private String design;
    private String producer;
    private String size;
    private String delivery;
    private String placeSell;
    private int clothesCategoryID;

    public Clothes() {
        super();
    }

    public Clothes(int id, String name, String brand, String color, String material, String design, String producer, String size, String delivery, String placeSell, int clothesCategoryID) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.design = design;
        this.producer = producer;
        this.size = size;
        this.delivery = delivery;
        this.placeSell = placeSell;
        this.clothesCategoryID = clothesCategoryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPlaceSell() {
        return placeSell;
    }

    public void setPlaceSell(String placeSell) {
        this.placeSell = placeSell;
    }

    public int getClothesCategoryID() {
        return clothesCategoryID;
    }

    public void setClothesCategoryID(int clothesCategoryID) {
        this.clothesCategoryID = clothesCategoryID;
    }

    
}
