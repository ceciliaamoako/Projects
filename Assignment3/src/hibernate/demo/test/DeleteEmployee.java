package hibernate.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;


public class DeleteEmployee 
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

			int emp_Id = 9;

			session.beginTransaction();	

			Employee employee = session.get(Employee.class, emp_Id);

			// Output employee info you are deleting
			System.out.println("Deleting Employee from the database: " + employee);
			
			// delete the employee with id = 9 from the database
			session.delete(employee);


			session.getTransaction().commit();

		}

		finally 
		{

			factory.close();

		}

	}

}
