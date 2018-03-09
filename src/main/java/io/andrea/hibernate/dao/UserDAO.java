package io.andrea.hibernate.dao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import io.andrea.hibernate.bean.User;

public class UserDAO {

	private static SessionFactory factory; 

	/**
	 *  Initialize SessionFactory 
	 */
	public UserDAO() {
		File configFile = new File("./config/hibernate.cfg.xml");

		try {
			factory = new Configuration().
					configure(configFile).
					addAnnotatedClass(User.class).
					buildSessionFactory();
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	/**
	 *  Method to CREATE an employee in the database 
	 */
	public Integer addUser(String fname, String lname){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userID = null;

		try {
			tx = session.beginTransaction();
			User user = new User();
			user.setName(fname);
			user.setSurname(lname);
			userID = (Integer) session.save(user); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return userID;
	}

	/**
	 *  Method to  READ all the employees 
	 */
	public void listUser( ){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery("FROM User").list(); 

			for (Iterator<User> iterator = users.iterator(); iterator.hasNext();){
				User user = (User) iterator.next();
				System.out.print("ID: " + user.getId());
				System.out.print("\tFirst Name: " + user.getName()); 
				System.out.print("\tLast Name: " + user.getSurname());
				System.out.println();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		System.out.println();
	}

	/**
	 *  Method to UPDATE salary for an employee 
	 */
	public void updateUser(Integer EmployeeID, String surname ){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = (User)session.get(User.class, EmployeeID); 
			user.setSurname(surname);
			session.update(user); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	/**
	 *  Method to DELETE an employee from the records 
	 */
	public void deleteEmployee(Integer UserID){
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = (User)session.get(User.class, UserID); 
			session.delete(user); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
}
