/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shoes;

import java.io.Serializable;

/**
 *
 * @author trung
 */
public class Shoes implements Serializable {
    private int id;
    private Category category;
    private String  size, material, trademark, pattern, color;
    private int gender;
    private  String description;
    private int promotion;
    
//    `ID` int NOT NULL,
//    `Type` varchar(20) NOT NULL,
//    `Size` varchar(20) NOT NULL,
//    `Trademark` varchar(20) NOT NULL,
//    `Materia` varchar(20) NOT NULL,
//    `Pattern` varchar(20) NOT NULL,
//    `Color` varchar(20) NOT NULL,
//    `Gender` tinyint(1) NOT NULL,
//    `Description` varchar(20) NOT NULL,
//    `Promotion` int NOT NULL,

    public Shoes() {
        
    }

    public Shoes(int id, Category category, String size, String material, String trademark, String pattern, String color, int gender, String description, int promotion) {
        this.id = id;
        this.category = category;
        this.size = size;
        this.material = material;
        this.trademark = trademark;
        this.pattern = pattern;
        this.color = color;
        this.gender = gender;
        this.description = description;
        this.promotion = promotion;
    }

    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }   
}
