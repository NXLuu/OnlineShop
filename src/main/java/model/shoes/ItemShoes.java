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
public class ItemShoes implements Serializable{
    
    private int id;
    private int idShoes;
    private String name;
    private float price;
    private String image;
    private float discount;

    public ItemShoes(int idShoes, String name, float price, String image, float discount) {
        this.idShoes = idShoes;
        this.name = name;
        this.price = price;
        this.image = image;
        this.discount = discount;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(int idShoes) {
        this.idShoes = idShoes;
    }

   

}
