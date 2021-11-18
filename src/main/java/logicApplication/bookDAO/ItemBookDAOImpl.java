package logicApplication.bookDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.book.Category;
import logicApplication.DAO.DAO;
import model.book.Author;
import model.book.Book;
import model.book.ItemBook;
import model.book.Publisher;
import model.book.Supplier;
import model.book.Translator;

public class ItemBookDAOImpl extends DAO implements ItemBookDAO {
	@Override
	public boolean insertItemBook(ItemBook itembook) {
		String sql = "INSERT INTO itembook(Barcode,BookID,Price,Intro,Discount) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itembook.getBarcode());
			ps.setString(2, itembook.getBook().getISBN());
			ps.setFloat(3, itembook.getPrice());
			ps.setString(4, itembook.getIntro());
			ps.setString(5, itembook.getDiscount());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItemBook(ItemBook itembook) {
		String sql = "UPDATE itembook SET Price=?, Intro=?,Discount=?  WHERE Barcode=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, itembook.getPrice());
			ps.setString(2, itembook.getIntro());
			ps.setString(3, itembook.getDiscount());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteItemBook(ItemBook itembook) {
		String sql = "DELETE FROM itembook WHERE Barcode=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itembook.getBarcode());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ItemBook getItemBook(String id) {
		String sql = "SELECT * FROM book WHERE ISBN = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setSummary(rs.getString("Summary"));
				book.setLanguage(rs.getString("Language"));
				book.setNumberOfPages(rs.getInt("NumberOfPages"));
				book.setSize(rs.getString("Size"));
				Supplier sup = new Supplier();
				Publisher pup = new Publisher();
				sup.setId(rs.getInt("SupplierID"));
				pup.setId(rs.getInt("PublisherID"));
				String sql1 = "SELECT * FROM supplier WHERE ID = ?";
				String sql2 = "SELECT * FROM publisher WHERE ID = ?";
				String sql3 = "SELECT * FROM bookauthor WHERE BookID = ?";
				String sql4 = "SELECT * FROM bookcategory WHERE BookID = ?";
				String sql5 = "SELECT * FROM booktranslator WHERE BookID = ?";
				try {
					PreparedStatement pss = con.prepareStatement(sql1);
					pss.setInt(1, sup.getId());
					ResultSet rss = pss.executeQuery();
					if (rss.next()) {
						sup.setName(rss.getString("Name"));
						book.setSupplier(sup);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psp = con.prepareStatement(sql2);
					psp.setInt(1, sup.getId());
					ResultSet rsp = psp.executeQuery();
					if (rsp.next()) {
						pup.setName(rsp.getString("Name"));
						pup.setAddress(rsp.getString("Address"));
						book.setPublisher(pup);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psa = con.prepareStatement(sql3);
					psa.setString(1, book.getISBN());
					ResultSet rsa = psa.executeQuery();
					ArrayList<Author> la = new ArrayList<>();
					while (rsa.next()) {
						Author a = new Author();
						la.add(a);
					}
					for (Author a : la) {
						String sa = "SELECT *FROM author WHERE ID = ?";
						try {
							PreparedStatement pa = con.prepareStatement(sa);
							pa.setInt(1, a.getId());
							ResultSet rssa = pa.executeQuery();
							if (rssa.next()) {
								a.setName(rssa.getString("Name"));
								a.setBiography(rssa.getString("Biography"));
								la.add(a);
							}
							book.setAuthor(la);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement pst = con.prepareStatement(sql5);
					pst.setString(1, book.getISBN());
					ResultSet rst = pst.executeQuery();
					ArrayList<Translator> lt = new ArrayList<>();
					while (rst.next()) {
						Translator t = new Translator();
						lt.add(t);
					}
					for (Translator t : lt) {
						String st = "SELECT *FROM translator WHERE ID = ?";
						try {
							PreparedStatement pt = con.prepareStatement(st);
							pt.setInt(1, t.getId());
							ResultSet rsst = pt.executeQuery();
							if (rsst.next()) {
								t.setName(rsst.getString("Name"));
								t.setBiography(rsst.getString("Biography"));

							}
							book.setTranslator(lt);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psc = con.prepareStatement(sql4);
					psc.setString(1, book.getISBN());
					ResultSet rst = psc.executeQuery();
					ArrayList<Category> lc = new ArrayList<>();
					while (rst.next()) {
						Category c = new Category();
						lc.add(c);
					}
					for (Category c : lc) {
						String st = "SELECT *FROM translator WHERE ID = ?";
						try {
							PreparedStatement pc = con.prepareStatement(st);
							pc.setInt(1, c.getId());
							ResultSet rssc = pc.executeQuery();
							if (rssc.next()) {
								c.setType(rssc.getString("Type"));
							}
							book.setCategory(lc);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ItemBook ib = new ItemBook();
				ib.setBook(book);
				String sqli = "SELECT * FROM itembook WHERE BookID = ?";
				try {
					PreparedStatement psi = con.prepareStatement(sqli);
					psi.setString(1, book.getISBN());
					ResultSet rsi = psi.executeQuery();
					while (rsi.next()) {
						ib.setBarcode(rsi.getString("Barcode"));
						ib.setPrice(rsi.getFloat("Price"));
						ib.setIntro(rsi.getString("Intro"));
						ib.setDiscount(rsi.getString("Discount"));
						ib.setImage(rsi.getString("Image"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return ib;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<ItemBook> findAll(String key) {
		ArrayList<ItemBook> result = new ArrayList<ItemBook>();
		ArrayList<Book> lb = new ArrayList<Book>();
		String sql = "SELECT * FROM book WHERE title LIKE ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setSummary(rs.getString("Summary"));
				book.setLanguage(rs.getString("Language"));
				book.setNumberOfPages(rs.getInt("NumberOfPages"));
				book.setSize(rs.getString("Size"));
				Supplier sup = new Supplier();
				Publisher pup = new Publisher();
				sup.setId(rs.getInt("SupplierID"));
				pup.setId(rs.getInt("PublisherID"));
				String sql1 = "SELECT * FROM supplier WHERE ID = ?";
				String sql2 = "SELECT * FROM publisher WHERE ID = ?";
				String sql3 = "SELECT * FROM bookauthor WHERE BookID = ?";
				String sql4 = "SELECT * FROM bookcategory WHERE BookID = ?";
				String sql5 = "SELECT * FROM booktranslator WHERE BookID = ?";
				try {
					PreparedStatement pss = con.prepareStatement(sql1);
					pss.setInt(1, sup.getId());
					ResultSet rss = pss.executeQuery();
					if (rss.next()) {
						sup.setName(rss.getString("Name"));
						book.setSupplier(sup);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psp = con.prepareStatement(sql2);
					psp.setInt(1, sup.getId());
					ResultSet rsp = psp.executeQuery();
					if (rsp.next()) {
						pup.setName(rsp.getString("Name"));
						pup.setAddress(rsp.getString("Address"));
						book.setPublisher(pup);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psa = con.prepareStatement(sql3);
					psa.setString(1, book.getISBN());
					ResultSet rsa = psa.executeQuery();
					ArrayList<Author> la = new ArrayList<>();
					while (rsa.next()) {
						Author a = new Author();
						la.add(a);
					}
					for (Author a : la) {
						String sa = "SELECT *FROM author WHERE ID = ?";
						try {
							PreparedStatement pa = con.prepareStatement(sa);
							pa.setInt(1, a.getId());
							ResultSet rssa = pa.executeQuery();
							if (rssa.next()) {
								a.setName(rssa.getString("Name"));
								a.setBiography(rssa.getString("Biography"));
								la.add(a);
							}
							book.setAuthor(la);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement pst = con.prepareStatement(sql5);
					pst.setString(1, book.getISBN());
					ResultSet rst = pst.executeQuery();
					ArrayList<Translator> lt = new ArrayList<>();
					while (rst.next()) {
						Translator t = new Translator();
						lt.add(t);
					}
					for (Translator t : lt) {
						String st = "SELECT *FROM translator WHERE ID = ?";
						try {
							PreparedStatement pt = con.prepareStatement(st);
							pt.setInt(1, t.getId());
							ResultSet rsst = pt.executeQuery();
							if (rsst.next()) {
								t.setName(rsst.getString("Name"));
								t.setBiography(rsst.getString("Biography"));

							}
							book.setTranslator(lt);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					PreparedStatement psc = con.prepareStatement(sql4);
					psc.setString(1, book.getISBN());
					ResultSet rst = psc.executeQuery();
					ArrayList<Category> lc = new ArrayList<>();
					while (rst.next()) {
						Category c = new Category();
						lc.add(c);
					}
					for (Category c : lc) {
						String st = "SELECT *FROM translator WHERE ID = ?";
						try {
							PreparedStatement pc = con.prepareStatement(st);
							pc.setInt(1, c.getId());
							ResultSet rssc = pc.executeQuery();
							if (rssc.next()) {
								c.setType(rssc.getString("Type"));
							}
							book.setCategory(lc);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ItemBook ib = new ItemBook();
				ib.setBook(book);
				String sqli = "SELECT * FROM itembook WHERE BookID = ?";
				try {
					PreparedStatement psi = con.prepareStatement(sqli);
					psi.setString(1, book.getISBN());
					ResultSet rsi = psi.executeQuery();
					while (rsi.next()) {
						ib.setBarcode(rsi.getString("Barcode"));
						ib.setPrice(rsi.getFloat("Price"));
						ib.setIntro(rsi.getString("Intro"));
						ib.setDiscount(rsi.getString("Discount"));
						ib.setImage(rsi.getString("Image"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				result.add(ib);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
