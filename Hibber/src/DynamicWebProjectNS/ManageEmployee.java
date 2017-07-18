package DynamicWebProjectNS;


	import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

	public class ManageEmployee {
	   protected static SessionFactory factory; 
	   public static void main(String[] args) {
	      try{
	         factory = ((AnnotationConfiguration)new AnnotationConfiguration().configure()).addAnnotatedClass(Employee.class).buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	        // throw new ExceptionInInitializerError(ex); 
	      }
	      ManageEmployee ME = new ManageEmployee();

	      /* Add few employee records in database */
	      ME.addEmployee("Zara Ali",27, "Delhi", 1000);
	      ME.addEmployee( "Daisy Das",28, "Delhi", 5000);
	      ME.addEmployee( "John Paul", 30, "Noida", 10000);
	      //Integer empID1 = 
	     // Integer empID2 = 
	      //Integer empID3 = 

	      /* List down all the employees */
	      ME.listEmployees();

	      /* Update employee's records */
	    //  ME.updateEmployee(empID1, 5000);

	      /* Delete an employee from the database */
	    //  ME.deleteEmployee(empID2);

	      /* List down new list of the employees */
	      ME.listEmployees();
	   }
	   /* Method to CREATE an employee in the database */
	   public void addEmployee( String Name, int Age, String Location, int Salary){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee();
	         employee.setName(Name);
	         employee.setLocation(Location);
	         employee.setSalary(Salary);
	         employee.setAge(Age);
	         
	         employee.setId((Integer) session.save(employee));
	          
	         tx.commit();
	      }catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	       
	   }
	   /* Method to  READ all the employees */
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("Id: " + employee.getId()); 
	            System.out.print("Name: " + employee.getName());
	            System.out.print("Age: " + employee.getAge());
	            System.out.print("Location: " + employee.getLocation()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to UPDATE salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                    (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to DELETE an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                   (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	}
