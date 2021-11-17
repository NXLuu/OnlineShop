package logicApplication.bookDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.book.Author;
import model.book.Book;
import model.book.Catogery;
import model.book.ItemBook;
import model.book.Publisher;
import model.book.Supplier;
import model.book.Translator;

public interface ItemBookDAOImpl {
	public boolean AddBook(ItemBook itembook);

	public boolean editBook(ItemBook itembook);

	public boolean deleteItemBook(ItemBook itembook);

	public ArrayList<ItemBook> searchItemBook(String key);
}
