/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shoes;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author trung
 */
public class Category  implements Serializable{
    
    public int id;
    public String type;

 
    public Category(String type) {
        this.type = type;
    }

    public Category(int id, String type) {
        this.id = id;
        this.type = type;
    }

    
    
}
