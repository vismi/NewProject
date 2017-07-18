package DynamicWebProjectNS;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	 @javax.persistence.Id @GeneratedValue
	 @Column(name = "Id")
	private int Id;
	 @Column(name = "Name")
	private String Name;
	 @Column(name = "Age")
	private int Age;
	 @Column(name = "Location")
	private String Location;
	 @Column(name = "Salary")
	private int Salary;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
	
	
}
