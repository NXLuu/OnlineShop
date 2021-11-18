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
public class ClothesCategory implements Serializable {
	private int id;
	private String type;

	public ClothesCategory() {
		super();
	}

	public ClothesCategory(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}