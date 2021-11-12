package hibernate.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;


public class SaveEmployee 
{

	public static void main(String[] args) throws ParseException 
	{
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Getting the right format for the Date attribute
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			//parsing the string type into a date object using simple date format
			Date myDate1 = formatter.parse("2000-07-26");
			Date myDate2 = formatter.parse("2021-05-4");
			Date myDate3 = formatter.parse("2011-08-12");
			
			
			// create the object of the Employee class
			Employee employee1 = new Employee("Loki","Laufeyson","Marvel",myDate1, 100000.00);
			Employee employee2 = new Employee("Peter","Quill","Marvel",myDate2,90000.00);
			Employee employee3 = new Employee("Wonder","Woman","DC",myDate3,78900.00);
			
			
			// start the transaction
			session.beginTransaction();
			
			// save the object to the database
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			//printing out the info of the saved employee
			System.out.println(employee1);
			System.out.println(employee2);
			System.out.println(employee3);
			
			// commit
			session.getTransaction().commit();	
			
		}
		finally
		{
			factory.close();
		}

	}

}







