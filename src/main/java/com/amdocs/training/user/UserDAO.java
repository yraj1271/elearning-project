package com.amdocs.training.user;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

	List<User> findAll();

	boolean addUser(User user);

	User getUserById(int id);

	boolean deleteUser(int id);
	
	boolean updateUser(User user) throws SQLException;
}



