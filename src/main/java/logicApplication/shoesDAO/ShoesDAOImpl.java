package logicApplication.shoesDAO;



import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.shoes.ItemShoes;
import model.shoes.Shoes;
import model.shoes.Category;

/**
 *
 * @author trung
 */
public class ShoesDAOImpl  extends DAO implements ShoesDAO{

  
	public ShoesDAOImpl() {
        super();
    }
    
	@Override
    public boolean inserShoes(Shoes shoes)  {
    	 
    	 
    	 
        String sql = "INSERT INTO shoes(ID, Type, Size, Materia, Trademark, Pattern, Color, Gender, Description, Promotion ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, shoes.getId());
            preStatement.setString(2, shoes.getSize());
            preStatement.setString(3, shoes.getSize());
            preStatement.setString(4, shoes.getMaterial());
            preStatement.setString(5, shoes.getTrademark());
            preStatement.setString(5, shoes.getPattern());
            preStatement.setString(7, shoes.getColor());
            preStatement.setInt(8, shoes.getGender());
            preStatement.setString(9, shoes.getDescription());
            preStatement.setInt(10, shoes.getPromotion());
            preStatement.executeUpdate();

            ResultSet rs = preStatement.getGeneratedKeys();
            
            while (rs.next()) {
                shoes.setId(rs.getInt(1));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
          
        }
    }

     @Override
    public boolean updateShoes(Shoes shoes) {
    	 
    	 
        String sql = "UPDATE shoes SET  Type =?, Size =?, Materia =?, Trademark=?, Pattern=?, Color=?, Gender=?, Description=?, Promotion=? WHERE ID=?";

        try {
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
           preStatement.setString(2, shoes.getCategory().type);
            preStatement.setString(3, shoes.getSize());
            preStatement.setString(4, shoes.getMaterial());
            preStatement.setString(5, shoes.getTrademark());
            preStatement.setString(5, shoes.getPattern());
            preStatement.setString(7, shoes.getColor());
            preStatement.setInt(8, shoes.getGender());
            preStatement.setString(9, shoes.getDescription());
            preStatement.setInt(10, shoes.getPromotion());
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

  

   

   @Override
    public List<Shoes> findAll() {
	   
	   
       
        List<Shoes> result = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from shoes");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               
                		result.add(new Shoes(
                                rs.getInt(1), 
                                new Category(rs.getInt(1),rs.getString(2)),
                    			 rs.getString(3),
                    			 rs.getString(4),
                    			 rs.getString(5),
                    			 rs.getString(6),
                    			 rs.getString(7),
                                rs.getInt(8),
                                rs.getString(9),
                                rs.getInt(10)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        
        return result;
        
    }


    @Override
    public boolean deleteShoes(Shoes Shoes) {
        String sql = "DELETE FROM shoes WHERE ID=?";
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, Shoes.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;}

 
    public Shoes getShoesByID(int id) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM shoes\n"
                    + "WHERE ID = ?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new Shoes(
                        id, 
                        new Category(id,rs.getString(2)),
            			 rs.getString(3),
            			 rs.getString(4),
            			 rs.getString(5),
            			 rs.getString(6),
            			 rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
   
 

}
