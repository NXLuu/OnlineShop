package logicApplication.bookDAO;

import java.util.ArrayList;

import model.book.Book;

interface BookDAO {
    public boolean insertBook(Book book);
    public boolean updateBook(Book book);
    public boolean deleteBook(Book book);
    public ArrayList<Book> findAll(String key);            
}