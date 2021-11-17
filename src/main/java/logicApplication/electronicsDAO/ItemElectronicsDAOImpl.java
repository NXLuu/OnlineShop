package logicApplication.electronicsDAO;
import model.electronics.ItemElectronic;

import java.util.List;

/**
 *
 * @author thevu
 */
public interface ItemElectronicsDAOImpl {
    public void insertElectronicsItem(ItemElectronic itemElectronic);
    public void updateElectronicsItem(ItemElectronic itemElectronic);
    public void deleteElectronicsItem(ItemElectronic itemElectronic);
    public List<ItemElectronic>  findAll();
}
