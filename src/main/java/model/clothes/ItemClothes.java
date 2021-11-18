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

public class ItemClothes implements Serializable {
	private int id;
	private Float price;
	private String image;
	private String description;
	private Clothes clothes;
//	    private int cartID;

	public ItemClothes() {
		super();
	}

	public ItemClothes(int id, Float price, String image, String description, Clothes clothes) {
		this.id = id;
		this.price = price;
		this.image = image;
		this.description = description;
		this.clothes = clothes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

}