package logicApplication.clothesDAO;

import java.util.ArrayList;

import model.clothes.ItemClothes;

public interface ItemClothesDAO {
	public ArrayList<ItemClothes> searchItemClothes(String key);

	public boolean addItemClothes(ItemClothes ic);

	public boolean editItemClothes(ItemClothes ic);

	public boolean deleteItemClothes(ItemClothes ic);
}
