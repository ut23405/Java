package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SyainDao {
	private static final String URL 
    	= "jdbc:mysql://localhost:3309/testphp";
	private static final String USER = "root";
	private static final String PASS = "";
	private static final String SQL 
		= "select * from syain;";

    public List<SyainDto> findAll() {
        List<SyainDto> syainList = new ArrayList<>();
        
	    try(Connection conn = 
	            DriverManager.getConnection(URL, USER, PASS);
	        PreparedStatement ps = conn.prepareStatement(SQL)){

	        try(ResultSet rs = ps.executeQuery()){
	            while (rs.next()) {
	            	SyainDto sd = new SyainDto();
	            	sd.setId(rs.getInt("id"));
	            	sd.setName(rs.getString("name"));
	            	sd.setRomaji(rs.getString("romaji"));
	            	syainList.add(sd);
	            }           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    }
        return syainList;
    }
}