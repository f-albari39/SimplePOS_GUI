import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String Query;
	
	public void open () throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/latortashop", "root", "");
		stmt = conn.createStatement();
	}
	
	public void close () throws Exception{
		conn.close();
		stmt.close();
		rs.close();
	}
	
	public ArrayList<ArrayList> cakeData(){
		
		ArrayList<ArrayList> fullData = new ArrayList<>();
		
		Query = 
				"SELECT c.CakeID, c.CakeName, b.BrandName, c.Stock, c.Price "+
				"FROM cake as c, brand b "+
				"WHERE c.BrandId = b.BrandId "+
				"ORDER BY c.CakeID";
		try {
			open();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
				ArrayList<String> data = new ArrayList<>();
				data.add(rs.getString("CakeID"));
				data.add(rs.getString("CakeName"));
				data.add(rs.getString("BrandName"));
				data.add(rs.getString("Stock"));
				data.add(rs.getString("Price"));
				
				fullData.add(data);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullData;
	}
	
	public void addMember(String email, String password, String phone, 
			String gender, String DOB, String address, String role){
		
		try {
			open();
			rs = stmt.executeQuery(Query);
			Query =
					"INSERT INTO member (Email, Password, Phone, DOB, Gender, Address, RoleName) "+
					"VALUES ('"+email+"','"+password+"','"+phone+"','"
					+DOB+"','"+gender+"','"+address+"','"+role+"')";
			PreparedStatement insert = conn.prepareStatement(Query);
	        insert.executeUpdate();
			close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Boolean validasiRegister(String email){
		try {
			Query =
					"SELECT Email, Password "+
					"FROM member "+ 
					"WHERE Email = '"+email+"'";
			open();
			rs = stmt.executeQuery(Query);
			
			while (rs.next()) {
				return false;
			}
			close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	
	public Boolean Login(String email, String password ){
		try {
			Query =
					"SELECT Email, Password "+
					"FROM member "+ 
					"WHERE Email = '"+email+"' AND Password = '"+password+"'";
			open();
			rs = stmt.executeQuery(Query);
			while (rs.next()) {
				return true;
			}
			close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}
	
	public DataBase() {
	}
}
