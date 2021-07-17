package test1;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.apache.log4j.PropertyConfigurator;

public class Test1Test {
    
    @Before
    public void testBefore() throws Exception {
		PropertyConfigurator.configure("log4j.properties");

		MySqlConnection MySqlconn = null;
		
		try(Connection conn = DriverManager.getConnection
		("jdbc:mysql://localhost:3309/testphp","root","")){
			
			MySqlconn = new MySqlConnection(conn,"testphp");
	         
	        IDataSet dataset = new CsvDataSet(new File("/data"));
	        DatabaseOperation.CLEAN_INSERT.execute(MySqlconn, dataset);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (DatabaseUnitException e) {
	        e.printStackTrace();
	    } finally {
	        if(MySqlconn != null){
	            try {
	            	MySqlconn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
    }
	@Test
	public void test() {
    	SyainDao syainDao = new SyainDao();
    	List<SyainDto> sd = syainDao.findAll();
    	assertThat(sd.get(1).getName(),is("田中")); //成功
	}
}