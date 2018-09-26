package com.darraghblake.employee.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.darraghblake.employee.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new Employee object.");
			Employee tempEmployee = new Employee("John", "Doe", "Apple");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee.");
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Complete.");
		} finally {
			factory.close();
		}
	}
	
}
