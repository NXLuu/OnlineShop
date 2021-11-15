package logicApplication.electronicsDAO;

import model.electronics.Electronic;

/**
 *
 * @author thevu
 */
public interface ElectronicsDAOImpl {
	public void insertElectronics(Electronic electronic);

	public void updateElectronics(Electronic electronic);

	public void deleteElectronics(Electronic electronic);
}
