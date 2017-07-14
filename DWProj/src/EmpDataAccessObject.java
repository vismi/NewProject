import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class EmpDataAccessObject {

	
	public static int add(Emp e) {
		int status = 0;
		try {Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Vismita","root","root"); 
			PreparedStatement ps = con.prepareStatement("insert into TableSample values(?,?,?,?)");
			
			ps.setString(1, e.Name);
			ps.setString(2, e.Email);
			ps.setString(3, e.DOB);
			ps.setString(4, e.MobileNo);
			ps.executeUpdate();  

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	
	public static int ViewAll()
	{	int status = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Vismita","root","root");
			Statement stmt=(Statement) con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from TableSample");  
			Emp emp = new Emp();
			while(rs.next())  
				{
					emp.Name = rs.getString(1);
					emp.Email = rs.getString(2);
					emp.DOB = rs.getString(3);
					emp.MobileNo = rs.getString(3);
					///System.out.println(emp.EmpId +"  "+emp.Name+"  "+emp.Salary );  PRINT
				}
		
		
	}catch (Exception ex) {
		ex.printStackTrace();
	}
	return status;
}
	

}



		
