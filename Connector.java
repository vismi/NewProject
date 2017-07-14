import java.sql.*;  
import java.util.*;

class Connector{  
 String url = "jdbc:mysql://localhost:3306/Vismita";
 Connection con;
 String TableName = "EmployeeTable";
 void OpenDB(String s)
 {
	 try{		this.TableName =s;
		 		Statement stmt=con.createStatement();  
				stmt.executeQuery("create database" + s+";");
				stmt.executeQuery("use" + s+";");
		 
		 
		 
		 
	 }catch(Exception e){ System.out.println(e);} 
	 
 }
  void Open(){
try{  
Class.forName("com.mysql.jdbc.Driver");  
 con=DriverManager.getConnection(  
url,"root","root");  
//here Vismita is database name, root is username and password  


}catch(Exception e){ System.out.println(e);}  
}  

  void Close(){
	 try{
	con.close(); 
 }catch(Exception e){ System.out.println(e);} 
 }

  void ReadAll(){
	  try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from EmployeeTable");  
		Employee emp = new Employee();
		while(rs.next())  
			{
				emp.EmpId = rs.getInt(1);
				emp.Name = rs.getString(2);
				emp.Salary = rs.getInt(3);
				System.out.println(emp.EmpId +"  "+emp.Name+"  "+emp.Salary );  
			}
	  }catch(Exception e){ System.out.println(e +"SDHGRAVEEEEZ");}
  }
  
  void CustomQuery(){																																				//EDIT
  
  try{	Scanner sc = new Scanner(System.in);
		Statement stmt=con.createStatement(); 
		System.out.println("Enter custom Query :");
		String s = sc.nextLine();
		ResultSet rs=stmt.executeQuery(s);
		Employee emp = new Employee();
		while(rs.next())  
			{
				emp.EmpId = rs.getInt(1);
				emp.Name = rs.getString(2);
				emp.Salary = rs.getInt(3);
				System.out.println(emp.EmpId +"  "+emp.Name+"  "+emp.Salary );  
			}	
}catch(Exception e){ System.out.println(e);}			
  }

  void AddEmployee(Employee e){
	  try{
	  Statement stmt=con.createStatement();
	  stmt.executeUpdate("insert into "+TableName+" values(+"+e.EmpId+", '"+e.Name+"',"+e.Salary+")");
	  }catch(Exception E){ System.out.println(E);}
  }
}
 