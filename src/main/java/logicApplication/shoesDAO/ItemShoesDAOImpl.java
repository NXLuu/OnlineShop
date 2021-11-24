package logicApplication.shoesDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.shoes.ItemShoes;






/**
 *
 * @author trung
 */
public class ItemShoesDAOImpl extends DAO implements ItemShoesDAO{
	private static final String DELETE_SQL = "delete from itemshoes where ID = ?;";
    public ItemShoesDAOImpl() {
        super();
    }
    
    
    
    @Override
    public List<ItemShoes> findAll() {
        List<ItemShoes> itemShoeses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from itemshoes");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                itemShoeses.add(new ItemShoes(
                        rs.getInt(1), 
                        rs.getNString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getFloat(5)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return itemShoeses;
    }
    
    public ItemShoes getItemShoesByID(int id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM itemshoes\n"
                    + "WHERE ID = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new ItemShoes(id, 
                		rs.getNString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getFloat(5));
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return null;
    }

     @Override
    public void inserShoesItem(ItemShoes itemShoes){
        String sql = "INSERT INTO itemshoes(ID, Name, Price, Image, Discount) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, itemShoes.getIdShoes());
            preStatement.setString(2, itemShoes.getName());
            preStatement.setFloat(3, itemShoes.getPrice());
            preStatement.setString(4, itemShoes.getImage());
            preStatement.setFloat(5, itemShoes.getDiscount());
            preStatement.executeUpdate();
          
            ResultSet rs = preStatement.getGeneratedKeys();
            while (rs.next()) {
                itemShoes.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
          
        }
    
    }
    private int getLastIdOf() {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT MAX(ID)\n"
                    + "FROM itemshoes");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return (rs.getByte(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public boolean updateShoesItem (ItemShoes itemShoes){
        String sql = "UPDATE itemshoes SET Name= ?, Price=?, Image=?, Discount=? WHERE ID=?;";
       
         try {
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setInt(1, itemShoes.getIdShoes());
            preStatement.setString(2, itemShoes.getName());
            preStatement.setFloat(3, itemShoes.getPrice());
            preStatement.setString(4, itemShoes.getImage());
            preStatement.setFloat(5, itemShoes.getDiscount());
           preStatement.executeUpdate() ;
           return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } 
         
    }
   
    @Override
    public boolean deleteShoesItem (ItemShoes itemShoes) {
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, itemShoes.getIdShoes());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
        
        
    }
    

   
   

}
