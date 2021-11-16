/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class ItemBook implements Serializable{
    private String barcode;
    private Book book;
    private float price;
    private String intro;
    private String discount;

    public ItemBook() {
        super();
    }

    public ItemBook(Book book, float price, String intro, String discount) {
        this.book = book;
        this.price = price;
        this.intro = intro;
        this.discount = discount;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    
    

    
}
