package hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;

public class RetrieveEmployee
{

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
			//initializing with the id of the employee
			int emp_Id = 3;

			session.beginTransaction();
				
			// Retrieving employee of this id
			Employee employee = session.get(Employee.class, emp_Id);

			System.out.println("The details of this employee with id "+ emp_Id + " is: " + "\n" + employee);

			//commit the transaction
			session.getTransaction().commit();

		}
		finally 
		{
			factory.close();
		}


	}
}


