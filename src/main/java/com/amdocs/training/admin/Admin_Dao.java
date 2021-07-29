package com.amdocs.training.admin;

import java.util.List;

public interface Admin_Dao {

	List<Admin> findAll();

	boolean addAdmin(Admin admin);

	Admin getAdminById(int id);

	boolean deleteAdmin(int id);
	
	boolean updateAdmin(Admin admin);
	
}
