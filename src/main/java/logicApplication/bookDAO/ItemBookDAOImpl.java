/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicApplication.bookDAO;

import static logicApplication.bookDAO.DAO.con;
import Model.Author;
import Model.Book;
import Model.Catogery;
import Model.ItemBook;
import Model.Publisher;
import Model.Supplier;
import Model.Translator;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * 
 * @author HP
 */
public class ItemBookDAOImpl extends DAO implements ItemBookDAO{
    @Override
    public boolean AddItemBook(ItemBook itembook){
        String sql = "INSERT INTO itembook(barcode,bookID,price,intro,discount) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1,itembook.getBarcode());
            ps.setString(2,itembook.getBook().getISBN());
            ps.setFloat(3,itembook.getPrice());
            ps.setString(4,itembook.getIntro());
            ps.setString(5,itembook.getDiscount());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
   public boolean EditItemBook(ItemBook itembook){
        String sql = "UPDATE itembook SET price=?, intro=?,discount=?  WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1,itembook.getPrice());
            ps.setString(2,itembook.getIntro());
            ps.setString(3,itembook.getDiscount());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
   }
   @Override
   public boolean DeleteItemBook(ItemBook itembook){
        String sql = "DELETE FROM itembook WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,itembook.getBarcode());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
   @Override
   public ArrayList<ItemBook> SearchItemBook(String key){
        ArrayList<ItemBook> result = new ArrayList<ItemBook>();
        String sql = "SELECT * FROM tblitembook WHERE name LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
 
            while(rs.next()){
                ItemBook itembook = new ItemBook();
                itembook.setBarcode(rs.getString("Barcode"));
                itembook.setPrice(rs.getFloat("Price"));
                itembook.setIntro(rs.getString("Intro"));
                itembook.setDiscount(rs.getString("Discount"));
                Book book = new Book();
                book.setISBN(rs.getString("ISBN"));
                String sqlB = "SELECT * FROM book WHERE ISBN LIKE ?";
                try{
                    PreparedStatement psB = con.prepareStatement(sqlB);
                    ps.setString(1,book.getISBN());
                    ResultSet rsB = ps.executeQuery();

                    while(rs.next()){
                        book.setTitle(rs.getString("Title"));
                        book.setSummary(rs.getString("Summary"));
                        book.setLanguage(rs.getString("Language"));
                        book.setNumberOfPages(rs.getInt("NumberOfPages"));
                        book.setSize(rs.getString("Size"));
                        Supplier sup =new Supplier();
                        Publisher pup =new Publisher();
                        sup.setId(rs.getInt("SupplierID"));
                        pup.setId(rs.getInt("PublisherID"));
                        String sql1= "SELECT * FROM supplier WHERE ID = ";
                        String sql2= "SELECT * FROM publisher WHERE ID = ";
                        String sql3= "SELECT * FROM bookauthor WHERE BookID = ";
                        String sql4= "SELECT * FROM bookcatogery WHERE BookID = ";
                        String sql5= "SELECT * FROM booktranslator WHERE BookID = ";
                        try {
                            PreparedStatement pss = con.prepareStatement(sql1);
                            pss.setInt(1,sup.getId());
                            ResultSet rss = pss.executeQuery();
                            if(rss.next()){
                                sup.setName(rss.getString("Name"));
                                book.setSupplier(sup);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            PreparedStatement psp = con.prepareStatement(sql1);
                            psp.setInt(1,sup.getId());
                            ResultSet rsp = psp.executeQuery();
                            if(rsp.next()){
                                pup.setName(rsp.getString("Name"));
                                pup.setAddress(rsp.getString("Address")); 
                                book.setPublisher(pup);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            PreparedStatement psa = con.prepareStatement(sql3);
                            psa.setString(1,book.getISBN());
                            ResultSet rsa = psa.executeQuery();
                            ArrayList<Author> la = new ArrayList<>();
                            while(rsa.next()){
                                Author a = new Author();
                                la.add(a);
                            }
                            for (Author a : la) {
                                String sa = "SELECT *FROM author WHERE ID = ?";
                                try {
                                    PreparedStatement pa = con.prepareStatement(sa);
                                    pa.setInt(1,a.getId());
                                    ResultSet rssa = pa.executeQuery();
                                    if(rssa.next()){
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
                            pst.setString(1,book.getISBN());
                            ResultSet rst = pst.executeQuery();
                            ArrayList<Translator> lt = new ArrayList<>();
                            while(rst.next()){
                                Translator t = new Translator();
                                lt.add(t);
                            }
                            for (Translator t : lt) {
                                String st = "SELECT *FROM translator WHERE ID = ?";
                                try {
                                    PreparedStatement pt = con.prepareStatement(st);
                                    pt.setInt(1,t.getId());
                                    ResultSet rsst = pt.executeQuery();
                                    if(rsst.next()){
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
                            psc.setString(1,book.getISBN());
                            ResultSet rst = psc.executeQuery();
                            ArrayList<Catogery> lc = new ArrayList<>();
                            while(rst.next()){
                                Catogery c = new Catogery();
                                lc.add(c);
                            }
                            for (Catogery c : lc) {
                                String st = "SELECT *FROM translator WHERE ID = ?";
                                try {
                                    PreparedStatement pc = con.prepareStatement(st);
                                    pc.setInt(1,c.getId());
                                    ResultSet rssc = pc.executeQuery();
                                    if(rssc.next()){
                                        c.setType(rssc.getString("Type"));
                                    }
                                    book.setCatogery(lc);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        itembook.setBook(book);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }   
                result.add(itembook);
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return result;
    }

    
}
