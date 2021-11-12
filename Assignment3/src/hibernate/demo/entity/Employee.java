package hibernate.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="join_date")
	private Date joinDate;
	
	
	@Column(name="salary")
	private double salary;
	

	public Employee()
	{
		
	}
	
	public Employee(String firstName, String lastName, String company,
			Date joinDate, double salary)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.joinDate = joinDate;
		this.salary = salary;			
		
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date datetime) {
		this.joinDate = datetime;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "emp_id = " + emp_id + "\n" 
				+ "firstName = " + firstName + "\n" 
				+ "lastName = " + lastName  + "\n"
				+ "company = " + company + "\n"
				+ "joinDate = " + joinDate + "\n"
				+ "salary = " + salary ;
	}
	
	

}


