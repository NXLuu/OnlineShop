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
public class ShoesCategory implements Serializable {
    
    private String type;

    public ShoesCategory() {
    }

    public ShoesCategory(String type) {
        this.type = type;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
