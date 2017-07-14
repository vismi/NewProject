import java.sql.*;  


class Runner{  
public static void main(String args[]){  
try{  
//System.out.println("Connecting to database");
Connector c = new Connector();
c.Open();//System.out.println("Opened connection");

//System.out.println("Opened database Vismita");

Employee employe1 = new Employee();
employe1.Add(87294,"Nikita Shah", 900000);//System.out.println("employe1 created");
c.AddEmployee(employe1);
c.ReadAll();

c.Close();
}catch(Exception e){ System.out.println(e);}  
}  
}  