package logicApplication.shoesDAO;

import java.util.List;
import model.shoes.ItemShoes;


public interface ItemShoesDAO {
	public void inserShoesItem(ItemShoes Shoes);
    public boolean updateShoesItem (ItemShoes Shoes);
    public boolean deleteShoesItem(ItemShoes Shoes);
    public List<ItemShoes> findAll();

}
