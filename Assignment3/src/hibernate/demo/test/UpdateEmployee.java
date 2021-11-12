package hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Employee;

public class UpdateEmployee 
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

			session.beginTransaction();

			int emp_Id = 6;
			Employee employee = session.get(Employee.class, emp_Id);
			
			//Using the setter methods to update employee name
			employee.setFirstName("Diana");
			employee.setLastName("Prince");

			
			System.out.println("Here is the updated info: " + "\n " + employee);

			// commit the transaction
			session.getTransaction().commit();


			session.getTransaction().commit();

		}

		finally 
		{
			factory.close();
		}

	}

}
