package logicApplication.clothesDAO;

import java.util.ArrayList;

import model.clothes.Clothes;

public interface ClothesDAO{
    public ArrayList<Clothes> searchClothes (String key);
    public boolean addClothes (Clothes clothes);
    public boolean editClothes (Clothes clothes);
    public boolean deleteClothes (Clothes clothes);
}