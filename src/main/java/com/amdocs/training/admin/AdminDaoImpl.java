package com.amdocs.training.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.Util.DBUtil;

public class AdminDaoImpl implements Admin_Dao{
	Connection conn=DBUtil.getConnection();
	@Override
	public List<Admin> findAll() {
		List<Admin> admin=new ArrayList<Admin>();
		String sql ="select * from admin";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next())
			{
				int admin_id=rs.getInt("admin_id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String password=rs.getString("password");
				
				Admin adminn=new Admin(admin_id,name,email,password);
				admin.add(adminn);
			}
			return admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		
		String query = "insert into admin values(?,?,?,?)";
		try {

			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setInt(1, admin.getAdmin_id());
			pst.setString(2, admin.getName());
			pst.setString(3, admin.getEmail());
			pst.setString(4,admin.getPassword());

			int row=pst.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
				System.out.println("Try again ");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Admin getAdminById(int id) {

		// TODO Auto-generated method stub
		try {
			String query = "select * from admin where admin_id= ?";
			
			
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			ResultSet rs = stat.executeQuery();
				rs.next();
				int idd=rs.getInt("admin_id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String password=rs.getString("password");				
				Admin admin=new Admin(idd, name,email,password);
				
				return admin;
				
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	@Override
	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		
			try {

				String query= "delete from admin where admin_id=?";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setInt(1, id);
				int row=ps.executeUpdate();
				if(row>0)
					return true;
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub	
		try {
			String query= "Update admin set name=? , email=? ,password=? where admin_id = ? ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, admin.getName());
			ps.setString(1, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.setInt(4, admin.getAdmin_id());
			int row=ps.executeUpdate();
			if(row>0)
				return true;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
