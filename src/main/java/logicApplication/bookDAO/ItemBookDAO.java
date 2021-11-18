package logicApplication.bookDAO;

import java.util.ArrayList;

import model.book.ItemBook;

public interface ItemBookDAO {
	public boolean insertItemBook(ItemBook itembook);

	public boolean updateItemBook(ItemBook itembook);

	public boolean deleteItemBook(ItemBook itembook);

	public ArrayList<ItemBook> findAll(String key);
}
