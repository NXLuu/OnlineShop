package logicApplication.bookDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logicApplication.DAO.DAO;
import model.book.*;

public class BookDAOImpl extends DAO implements BookDAO {
	@Override
	public boolean insertBook(Book book) {
		String sql = "INSERT INTO book(ISBN,Title,Summary,PublicationDate,NumberOfPages,Language,Size,PublisherID,SupplierID) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getISBN());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getSummary());
			ps.setDate(4, (Date) book.getPublicationDate());
			ps.setInt(5, book.getNumberOfPages());
			ps.setString(6, book.getLanguage());
			ps.setString(7, book.getSize());
			ps.setInt(8, book.getPublisher().getId());
			ps.setInt(9, book.getSupplier().getId());
			ps.executeUpdate();
			for (Author a : book.getAuthor()) {
				String sqlBA = "INSERT INTO bookauthor(BookID,AuthorID) VALUES (?,?)";
				try {
					PreparedStatement psBA = con.prepareStatement(sqlBA);
					// PreparedStatement psc = con.prepareStatement(sqlp);
					psBA.setString(1, book.getISBN());
					psBA.setInt(2, a.getId());
					ResultSet rsBA = psBA.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			for (Category c : book.getCategory()) {
				String sqlBC = "INSERT INTO bookcategory(BookID,CategoryID) VALUES (?,?)";
				try {
					PreparedStatement psBC = con.prepareStatement(sqlBC);
					// PreparedStatement psc = con.prepareStatement(sqlp);
					psBC.setString(1, book.getISBN());
					psBC.setInt(2, c.getId());
					ResultSet rsBC = psBC.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			for (Translator t : book.getTranslator()) {
				String sqlBT = "INSERT INTO booktranslator(BookID,TranslatorID) VALUES (?,?)";
				try {
					PreparedStatement psBT = con.prepareStatement(sqlBT);
					psBT.setString(1, book.getISBN());
					psBT.setInt(2, t.getId());
					ResultSet rsBT = psBT.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "UPDATE book SET Title=?,Summary=?,PublicationDate=?,NumberOfPages=?,Language=?,Size=?,PublisherID=?,SupplierID=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getSummary());
			ps.setDate(3, (Date) book.getPublicationDate());
			ps.setInt(4, book.getNumberOfPages());
			ps.setString(5, book.getLanguage());
			ps.setString(6, book.getSize());
			ps.executeUpdate();
			for (Author a : book.getAuthor()) {
				String sqlBA = "UPDATE bookauthor SET AuthorID =? WHERE bookID = ?";
				try {
					PreparedStatement psBA = con.prepareStatement(sqlBA);
					// PreparedStatement psc = con.prepareStatement(sqlp);
					psBA.setString(2, book.getISBN());
					psBA.setInt(1, a.getId());
					ResultSet rsBA = psBA.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			for (Category c : book.getCategory()) {
				String sqlBC = "UPDATE bookcategory SET CategoryID=?  WHERE bookID = ?";
				try {
					PreparedStatement psBC = con.prepareStatement(sqlBC);
					// PreparedStatement psc = con.prepareStatement(sqlp);
					psBC.setString(1, book.getISBN());
					psBC.setInt(2, c.getId());
					ResultSet rsBC = psBC.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			for (Translator t : book.getTranslator()) {
				String sqlBT = "UPDATE booktranslator SET TranslatorID=?  WHERE bookID = ?";
				try {
					PreparedStatement psBT = con.prepareStatement(sqlBT);
					psBT.setString(2, book.getISBN());
					psBT.setInt(1, t.getId());
					ResultSet rsBT = psBT.getGeneratedKeys();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBook(Book book) {
		String sql = "DELETE FROM book WHERE ISBN=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getISBN());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Book> findAll(String key) {
		ArrayList<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM book WHERE name LIKE ?";
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
					PreparedStatement psp = con.prepareStatement(sql1);
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
				result.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}