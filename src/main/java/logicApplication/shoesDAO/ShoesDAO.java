package logicApplication.shoesDAO;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import model.shoes.Shoes;


/**
 *
 * @author Trung NV
 */
public interface ShoesDAO {
    public boolean inserShoes(Shoes Shoes);
     public boolean updateShoes(Shoes Shoes);
     public boolean deleteShoes(Shoes Shoes);
     public List<Shoes> findAll();
}
