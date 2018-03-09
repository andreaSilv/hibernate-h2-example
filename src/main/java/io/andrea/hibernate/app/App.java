package io.andrea.hibernate.app;

import io.andrea.hibernate.dao.UserDAO;

public class App {

	public static void main(String[] args) {
		
		UserDAO dbDAO = new UserDAO();

		/* Add few employee records in database */
		Integer empID1 = dbDAO.addUser("Zara", "Ali");
		
		Integer empID2 = dbDAO.addUser("Daisy", "Das");
		
		@SuppressWarnings("unused")
		Integer empID3 = dbDAO.addUser("John", "Paul");

		/* List down all the employees */
		dbDAO.listUser();

		/* Update employee's records */
		dbDAO.updateUser(empID1, "Alinus");
		
		/* List down updated list of the employees */
		dbDAO.listUser();

		/* Delete an employee from the database */
		dbDAO.deleteEmployee(empID2);

		/* List down new list of the employees */
		dbDAO.listUser();
	}
}
