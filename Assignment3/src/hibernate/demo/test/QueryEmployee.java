package hibernate.demo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.demo.entity.Employee;

public class QueryEmployee 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
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

			// begin transaction
			session.beginTransaction();

			// Create a query to retrieve all employees in the marvel company
			List<Employee> employees = (List<Employee>) session.createQuery("from Employee s where s.company='Marvel' ").getResultList();


			// Display the employees
			showEmployees(employees);

			// commit the transaction
			session.getTransaction().commit();

		}
		finally 
		{
			factory.close();
		}
		
	}

	//a way of using list data structure to display the employees
	private static void showEmployees(List<Employee> theEmployee) 
	{

		for (Employee employee:theEmployee) 
		{
			System.out.println(employee);
		}

	}




}


