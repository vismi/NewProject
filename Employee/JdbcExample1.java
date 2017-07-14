import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample1
{
	public static void main(String[] args) {
	Connection con = null;
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:mysql://localhost::3306/Employee","root","root");
		if(!con.isClosed())
		{
			System.out.println("Succesfully connected");

		}
	}	catch(Exception e)
	{
		System.err.println("Eception: "+ e.getMessage());

	}finally{
		try{
			if(con!=null)
				con.close();
		}catch(SQLException e){}
	}
	}
	
}